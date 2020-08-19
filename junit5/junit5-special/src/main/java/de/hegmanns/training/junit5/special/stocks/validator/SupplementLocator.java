package de.hegmanns.training.junit5.special.stocks.validator;

import de.hegmanns.training.junit5.special.stocks.Exchange;
import de.hegmanns.training.junit5.special.stocks.Order;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Every exchange but xetra:
 *  only valid current day: LIMIT, STOP, AUCTION_ONLY, FILL_OR_KILL
 *  all other: LIMIT, STOP, StOP_LIMIT
 *
 * For exchange xetra:
 *  xetra-type 'A':
 *      valid current day: LIMIT, STOP, STOP_LIMIT, AUCTION_ONLY;
 *      all other: LIMIT, STOP, StOP_LIMIT, FILL_OR_KILL;
 *
 *  xetra-type 'B':
 *      valid current day: LIMIT;
 *      all other: LIMIT, STOP, StOP_LIMIT, AUCTION_ONLY, FILL_OR_KILL;
 *
 *  xetra-type 'C':
 *      valid current day: AUCTION_ONLY;
 *      all other: LIMIT, STOP, STOP_LIMIT
 *
 *  xetra-type 'D':
 *      valid current day: LIMIT, STOP, StOP_LIMIT, AUCTION_ONLY, FILL_OR_KILL;
 *      all other: LIMIT, STOP, StOP_LIMIT, AUCTION_ONLY, FILL_OR_KILL;
 *
 *  all other xetra-types:
 *      valid current day: LIMIT;
 *      all other: LIMIT, STOP, StOP_LIMIT, AUCTION_ONLY;
 */
public class SupplementLocator {

    private static Set<Supplement> XETRA_A_DAY = SupplementsBuilder.create().add(Supplement.LIMIT).add(Supplement.STOP).add(Supplement.FILL_OR_KILL).add(Supplement.AUCTION_ONLY).build();
    private static Set<Supplement> XETRA_A_OTHER = SupplementsBuilder.create().add(Supplement.LIMIT).add(Supplement.STOP).add(Supplement.STOP_LIMIT).build();

    private static Set<Supplement> XETRA_B_DAY = SupplementsBuilder.create().add(Supplement.LIMIT).build();
    private static Set<Supplement> XETRA_B_OTHER = SupplementsBuilder.create().add(Supplement.LIMIT).add(Supplement.STOP).add(Supplement.STOP_LIMIT).add(Supplement.AUCTION_ONLY).add(Supplement.FILL_OR_KILL).build();


    private static Set<Supplement> XETRA_C_DAY = SupplementsBuilder.create().add(Supplement.AUCTION_ONLY).build();
    private static Set<Supplement> XETRA_C_OTHER = SupplementsBuilder.create().add(Supplement.LIMIT).add(Supplement.STOP).add(Supplement.STOP_LIMIT).build();

    private static Set<Supplement> XETRA_D_DAY = SupplementsBuilder.create().add(Supplement.LIMIT).add(Supplement.STOP).add(Supplement.STOP_LIMIT).add(Supplement.AUCTION_ONLY).add(Supplement.FILL_OR_KILL).build();
    private static Set<Supplement> XETRA_D_OTHER = SupplementsBuilder.create().add(Supplement.LIMIT).add(Supplement.STOP).add(Supplement.STOP_LIMIT).add(Supplement.FILL_OR_KILL).build();

    private static Set<Supplement> XETRA_OTHER_DAY = SupplementsBuilder.create().add(Supplement.LIMIT).build();
    private static Set<Supplement> XETRA_OTHER_OTHER = SupplementsBuilder.create().add(Supplement.LIMIT).add(Supplement.STOP).add(Supplement.STOP_LIMIT).add(Supplement.AUCTION_ONLY).build();


    public Set<Supplement> getPossibleSupplements(Order order) {
         if (!isXetra(order.getExchange())) {
             if (isExpireToday(order)) {
                 return SupplementsBuilder.create()
                         .add(Supplement.LIMIT).add(Supplement.STOP).add(Supplement.AUCTION_ONLY).add(Supplement.FILL_OR_KILL)
                         .build();
             }else{
                 return SupplementsBuilder.create()
                         .add(Supplement.LIMIT).add(Supplement.STOP).add(Supplement.STOP_LIMIT)
                         .build();
             }
         }else{
             return createIfTypeA(order).orElse(createIfTypeB(order).orElse(createIfTypeC(order).orElse(createIfTypeD(order).orElse(createIfTypeOther(order).orElseThrow(() -> new RuntimeException("no valid xetra type"))))));
         }

     }

    private Optional<Set<Supplement>> createIfTypeA(Order order) {
        if (order.getStock() == null || !order.getStock().getXetraType().equals("A")) {
            return Optional.empty();
        }
        if (isExpireToday(order)) {
            return Optional.of(XETRA_A_DAY);
        }else{
            return Optional.of(XETRA_A_OTHER);
        }
    }

    private Optional<Set<Supplement>> createIfTypeB(Order order) {
        if (order.getStock() == null || !order.getStock().getXetraType().equals("B")) {
            return Optional.empty();
        }
        if (isExpireToday(order)) {
            return Optional.of(XETRA_B_DAY);
        }else{
            return Optional.of(XETRA_B_OTHER);
        }
    }

    private Optional<Set<Supplement>> createIfTypeC(Order order) {
        if (order.getStock() == null || !order.getStock().getXetraType().equals("C")) {
            return Optional.empty();
        }
        if (isExpireToday(order)) {
            return Optional.of(XETRA_C_DAY);
        }else{
            return Optional.of(XETRA_C_OTHER);
        }
    }

    private Optional<Set<Supplement>> createIfTypeD(Order order) {
        if (order.getStock() == null || !order.getStock().getXetraType().equals("D")) {
            return Optional.empty();
        }
        if (isExpireToday(order)) {
            return Optional.of(XETRA_D_DAY);
        }else{
            return Optional.of(XETRA_D_OTHER);
        }
    }

    private Optional<Set<Supplement>> createIfTypeOther(Order order) {
        if (order.getStock() == null) {
            return Optional.empty();
        }
        if (isExpireToday(order)) {
            return Optional.of(XETRA_OTHER_DAY);
        }else{
            return Optional.of(XETRA_OTHER_OTHER);
        }
    }

     static class SupplementsBuilder{

         Set<Supplement> supplements;

         SupplementsBuilder() {
             supplements = new HashSet<>();
         }

         public static SupplementsBuilder create() {
             return new SupplementsBuilder();
         }
         public SupplementsBuilder add(Supplement supplement) {
             supplements.add(supplement);
             return this;
         }

         public Set<Supplement> build() {
             return supplements;
         }
    }
    private boolean isExpireToday(Order order) {
        return order.getExpireDate() != null && !order.getExpireDate().isAfter(LocalDate.now());
    }

    private boolean isXetra(Exchange exchange) {
        return exchange != null && exchange.getExchangeName() != null && exchange.getExchangeName().toLowerCase().equals("xetra");
    }
}

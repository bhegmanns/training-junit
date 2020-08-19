package de.hegmanns.training.junit5.structure.testinterface;

public class CoreIntegerTest implements TestableInstance<Integer>, Accessor<Integer, String>, CheckEquals<Integer, String>{

    @Override
    public Integer createUnequalValue() {
        return 200;
    }

    @Override
    public String getValueFrom(Integer instance) {
        return "" + instance.intValue();
    }

    @Override
    public Integer getInstance() {
        return 100;
    }
}

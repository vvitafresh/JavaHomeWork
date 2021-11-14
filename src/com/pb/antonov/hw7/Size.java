package com.pb.antonov.hw7;

public enum Size {
    // enum fields
    XXS(32, "Детский размер"),
    XS(34,"Взрослый размер"),
    S(36,"Взрослый размер"),
    M(38,"Взрослый размер"),
    L(40,"Взрослый размер");

    // internal state
    private int euroSize;
    private String description;

    // constructor
    private Size(final int euroSize, final String description){
        this.euroSize=euroSize;
        this.description=description;
    }

    public String getDesctiption(){
        return description;
    }

    public int getEuroSize(){
        return euroSize;
    }

}

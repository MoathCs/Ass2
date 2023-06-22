package model;

public class EquationDI {  //factory
    public Iequations getModel(){
        return new EquationDa();
    }
}

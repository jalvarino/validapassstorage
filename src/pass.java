public class pass {
    private String contra;
    private boolean resultado;

    public pass(String contra, boolean resultado) {
        this.contra = contra;
        this.resultado = resultado;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra ) {
        this.contra = contra;
    }

    public boolean getResultado() {
        return resultado;
    }

    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }
}

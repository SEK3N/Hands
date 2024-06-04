class Intervalo {

    private final double limiteInferior;
    private final double limiteSuperior;
    private int frecuenciaAbsoluta;
    private double puntoMedio;
    private int frecuenciaAcumulada;
    private double frecuenciaRelativa;
    private double frecuenciaRelativaAcumulada;
    private double porcentajeFrecuenciaRelativa;
    private double porcentajeFrecuenciaRelativaAcumulada;

    public void setFrecuenciaAcumulada(int frecuenciaAcumulada) {
        this.frecuenciaAcumulada = frecuenciaAcumulada;
    }

    public Intervalo(double limiteInferior, double limiteSuperior, int frecuenciaAbsoluta) {
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
        this.frecuenciaAbsoluta = frecuenciaAbsoluta;
    }

    public void calcularPuntoMedio() {
        this.puntoMedio = (this.limiteInferior + this.limiteSuperior) / 2;
    }

    public void calcularFrecuenciaRelativa(int total) {
        this.frecuenciaRelativa = (double) this.frecuenciaAbsoluta / total;
    }

    public void calcularPorcentajeFrecuenciaRelativa() {
        this.porcentajeFrecuenciaRelativa = this.frecuenciaRelativa * 100.00;
    }

    public void setFrecuenciaRelativaAcumulada(double frecuenciaRelativaAcumulada) {
        this.frecuenciaRelativaAcumulada = frecuenciaRelativaAcumulada;
    }

    public void calcularPorcentajeFrecuenciaRelativaAcumulada() {
        this.porcentajeFrecuenciaRelativaAcumulada = this.frecuenciaRelativaAcumulada * 100;
    }

    public String toString() {
        return String.format("| %.2f - %.2f |    %-4d |%7.2f |    %-4d |  %6.2f | %2.2f%% | %7.2f    |   %3.2f%%   |",
                this.limiteInferior, this.limiteSuperior, this.frecuenciaAbsoluta, this.puntoMedio, this.frecuenciaAcumulada,
                this.frecuenciaRelativa, this.porcentajeFrecuenciaRelativa, this.frecuenciaRelativaAcumulada,
                this.porcentajeFrecuenciaRelativaAcumulada);
    }
}
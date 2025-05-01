

package Modelo;

import java.io.Serializable;

public class Cliente implements  Serializable{
    int idPersona, idCliente,totalProductos, totalPagos;
    double precioPromedio, totalFacturasUltimoMes, cupo, pagoUltimoMes; 

    public Cliente(int idPersona, int idCliente,   int totalProductos, int totalPagos, double precioPromedio, double totalFacturasUltimoMes, double cupo, double pagoUltimoMes) {
        this.idPersona = idPersona;
        this.idCliente = idCliente; 
        this.totalProductos = totalProductos;
        this.totalPagos = totalPagos;
        this.precioPromedio = precioPromedio;
        this.totalFacturasUltimoMes = totalFacturasUltimoMes;
        this.cupo = cupo;
        this.pagoUltimoMes = pagoUltimoMes;

        // totalProductos
        // pagos
        // precioPromedio
        // tal totalFacturasUltimoMes
        // cupo
        // pago
        
    }

        public int getIdPersona() {
            return idPersona;
        }

        public void setIdPersona(int idPersona) {
            this.idPersona = idPersona;
        }

        public int getTotalProductos() {
            return totalProductos;
        }

        public void setTotalProductos(int totalProductos) {
            this.totalProductos = totalProductos;
        }

        public int getTotalPagos() {
            return totalPagos;
        }

        public void setTotalPagos(int totalPagos) {
            this.totalPagos = totalPagos;
        }

        public double getPrecioPromedio() {
            return precioPromedio;
        }

        public void setPrecioPromedio(double precioPromedio) {
            this.precioPromedio = precioPromedio;
        }

        public double getTotalFacturasUltimoMes() {
            return totalFacturasUltimoMes;
        }

        public void setTotalFacturasUltimoMes(double totalFacturasUltimoMes) {
            this.totalFacturasUltimoMes = totalFacturasUltimoMes;
        }

        public double getCupo() {
            return cupo;
        }

        public void setCupo(double cupo) {
            this.cupo = cupo;
        }

        public double getPagoUltimoMes() {
            return pagoUltimoMes;
        }

        public void setPagoUltimoMes(double pagoUltimoMes) {
            this.pagoUltimoMes = pagoUltimoMes;
        }
    
  

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return ("Id persona: " + idPersona + "\n" +  "Cupo: " + cupo );
    }
}

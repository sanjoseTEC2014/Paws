package paws.modelo;

/**	Clase Mascota: 
 * 	Esta clase implementa cada uno de los atributos,
 *  listas y m�todos correspondientes a las mascotas.
 * 
 *	Fecha de creaci�n: 24/10/2014
 * 
 *	@author Isaac Antonio Campos Mes�n 2014004626
 *	@author Liza Elena Chaves Carranza 2013016573
 *	@author Melissa Mar�a Molina Corrales 2013006074
 *	@author Luis Andr�s Pe�a Castillo 2014057250 
 *  
 */

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import paws.control.EstadosMascotas;
import paws.control.Imagenes;
import paws.control.excepciones.EventoNoExisteException;
import paws.control.excepciones.ImagenNoEncontradaException;
import paws.control.excepciones.TiempoSinEstablecerException;
import paws.modelo.Suceso;

public class Mascota implements Serializable {

	private static final long serialVersionUID = 111L;
	
	private static final List<String> tamanios = Arrays.asList("Peque�o", "Mediano", "Grande");
	private static LinkedList<String> colores = new LinkedList<String>();
	private static LinkedList<String> especies = new LinkedList<String>();
	private static LinkedList<LinkedList<String>> razas = new LinkedList<LinkedList<String>>();
	
	private static Integer totalIDsRegistradas;

	private Integer id;
	private String nombre;
	private String especie;
	private String raza;
	private Integer recompensa;
	
	private String numeroChip;
	private String color;
	private String edad;
	private String sexo;
	private Boolean castrada;
	private Boolean vacunada;
	private Boolean desparacitada;
	private String tamanio;
	private Suceso[] sucesos; // Para cada suceso del array corresponde un estado
	// 0 = Desaparecida; 1 = Encontrada; 2 = Refugiada; 3 = Localizada; 4 = Adoptada; 5 = Muerta
	private Boolean[] marcadoresEstado;
	private Boolean[] marcadoresEspera; //0 = Localizacion, 1 = Refugio, 2 = Adopcion
	

	public Mascota(String pNombre, String pEspecie, String pRaza, Integer pRecompensa) throws TiempoSinEstablecerException {
		id = ++totalIDsRegistradas;
		nombre = pNombre;
		especie = pEspecie;
		raza = pRaza;
		recompensa = pRecompensa;
		// Valores por defecto
		color = "";
		edad = "";
		sexo = "";
		castrada = false;
		vacunada = false;
		desparacitada = false;
		recompensa = pRecompensa;
		sucesos = new Suceso[]{new Suceso(), new Suceso(), new Suceso(), new Suceso(), new Suceso(), new Suceso()}; 
		marcadoresEstado = new Boolean[6];
		for (int i = 0; i < marcadoresEstado.length; i++) { marcadoresEstado[i] = false; }
		marcadoresEspera = new Boolean[3];
		for (int i = 0; i < marcadoresEspera.length; i++) { marcadoresEspera[i] = false; }
		tamanio = "";
	}

	public Integer getID() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroChip() {
		return numeroChip;
	}

	public void setChip(String string) {
		this.numeroChip = string;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public boolean isCastrada() {
		return castrada;
	}

	public void setCastrada(boolean castrada) {
		this.castrada = castrada;
	}

	public boolean isVacunada() {
		return vacunada;
	}

	public void setVacunada(boolean vacunada) {
		this.vacunada = vacunada;
	}

	public boolean isDesparacitada(){
		return desparacitada;
	}

	public void setDesparacitada(boolean desparacitada) {
		this.desparacitada = desparacitada;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public void addNuevoSuceso(Suceso pSuceso) {
		
		String estados[] = {EstadosMascotas.estadoDESAPARECIDA,
                EstadosMascotas.estadoENCONTRADA,
                EstadosMascotas.estadoREFUGIADA,
                EstadosMascotas.estadoLOCALIZADA,
                EstadosMascotas.estadoADOPTADA,
                EstadosMascotas.estadoMUERTA};
				
		for (int i = 0; i < marcadoresEstado.length; i++){
		    if (pSuceso.getEstado().equals(estados[i])){
		        marcadoresEstado[i] = true;
		        sucesos[i] = pSuceso;
		    } else {
		        marcadoresEstado[i] = false;
		    }
		}
		
	}
	
	public boolean isEsperandoLocalizacion(){
		return marcadoresEspera[0];
	}
	
	public boolean isEsperandoRefugio(){
		return marcadoresEspera[1];
	}
	
	public boolean isEsperandoAdopcion(){
		return marcadoresEspera[2];
	}
	
	public void setEsperaNinguna(){
		marcadoresEspera[0] = false;
		marcadoresEspera[1] = false;
		marcadoresEspera[2] = false;
	}
	
	public void setEsperaLocalizacion(){
		marcadoresEspera[0] = true;
		marcadoresEspera[1] = false;
		marcadoresEspera[2] = false;
	}
	
	public void setEsperaRefugio(){
		marcadoresEspera[0] = true;
		marcadoresEspera[1] = false;
		marcadoresEspera[2] = false;
	}
	
	public void setEsperaAdopcion(){
		marcadoresEspera[0] = true;
		marcadoresEspera[1] = false;
		marcadoresEspera[2] = false;
	}
	
	public void notificar(String pMensaje, String pNickEmisor) throws EventoNoExisteException, TiempoSinEstablecerException {
		Suceso temp = EstadosMascotas.reportarEvento(this, pNickEmisor, pMensaje);
		if (!temp.getNick().equals("")) addNuevoSuceso(temp); // Si el suceso tiene que cambiar.
	}
	
	public Integer getRecompensa() {
		return recompensa;
	}

	public void setRecompensa(Integer recompensa) {
		this.recompensa = recompensa;
	}
	
	public Suceso[] getTodosSucesos() {
		return sucesos;
	}
	
	public Suceso getUltimoSuceso() {		
		for (int i = 0; i < marcadoresEstado.length; i++){
			if (marcadoresEstado[i]) { return sucesos[i]; }
		}
		throw new NullPointerException("No se encuentra ning�n suceso.");
	}
	
	public boolean isDesaparecida() {
		return marcadoresEstado[0];
	}
	public boolean isEncontrada() {
		return marcadoresEstado[1];
	}
	public boolean isRefugiada() {
		return marcadoresEstado[2];
	}
	public boolean isLocalizada() {
		return marcadoresEstado[3];
	}
	public boolean isAdoptada() {
		return marcadoresEstado[4];
	}
	public boolean isMuerta() {
		return marcadoresEstado[5];
	}

	public BufferedImage getImagen() throws ImagenNoEncontradaException{
		return Imagenes.getPerfilMascota(id);
	}
	
	public void setImagen(String imagenSeleccionada) {
		Imagenes.guardarFotoPerfilMascota(id, imagenSeleccionada);		
	}
	
	public String toString() {
//		String msg = "ID: " + id;
//		msg += "\nNombre de la mascota: " + nombre;
//		msg += "\nChip: " + numeroChip;
//		msg += "\nEspecie: " + especie;
//		msg += "\nRaza: " + raza;
//		msg += "\nColor: " + color;
//		msg += "\nEdad: " + edad;
//		msg += "\nSexo: " + sexo;
//		msg += "\nCastrada: " + (castrada ? "S�" : "No");
//		msg += "\nVacunada: " + (vacunada ? "S�" : "No");
//		msg += "\nDesparacitada: " + (desparacitada ? "S�" : "No");
//		msg += "\nTama�o: " + tamanio;
//		msg += "\nMarcadores Estado:";
//		for (int i = 0; i < marcadoresEstado.length; i++) { 
//			msg += " " + marcadoresEstado[i];
//		}
//		for (int i = 0; i < marcadoresEstado.length; i++) {
//			if (marcadoresEstado[i]) msg += "\nEstado Actual: " + sucesos[i].getEstado();
//		}
//		msg += "\nEsperando Localizaci�n: " + (marcadoresEspera[0] ? "S�" : "No");
//		msg += "\nEsperando Refugio: " 		+ (marcadoresEspera[1] ? "S�" : "No");
//		msg += "\nEsperando Adopci�n: " 	+ (marcadoresEspera[2] ? "S�" : "No");
//		return msg;
		return new Boolean(marcadoresEstado == null).toString();
	}
	
	// Constructor invocado unicamente por el metodo .clone()
	private Mascota(Integer pID) {
		id = pID;
	}
	
	public Mascota clone() {
		Mascota clone = new Mascota(this.id);
		clone.nombre = this.nombre;
		clone.especie = this.especie;
		clone.raza = this.raza;
		clone.recompensa = this.recompensa;
		clone.numeroChip = this.numeroChip;
		clone.color = this.color;
		clone.edad = this.edad;
		clone.sexo = this.sexo;
		clone.castrada = this.castrada;
		clone.vacunada = this.vacunada;
		clone.desparacitada = this.desparacitada;
		clone.sucesos = this.sucesos.clone(); 
		clone.marcadoresEstado = this.marcadoresEstado.clone();
		clone.marcadoresEspera = this.marcadoresEspera.clone();
		clone.tamanio = this.tamanio;
		return clone;
	}

	public static DefaultComboBoxModel<String> getModeloEspecies() {
		int size = especies.size();
		return new DefaultComboBoxModel<String>(especies.toArray(new String[size]));
	}
	
	// Recibe la especie seleccionada en el JComboBox para que e'ste pueda refrescarse
	// cuando se esta' editando la especie de una Mascota.
	public static DefaultComboBoxModel<String> getModeloRazas(String pEspecie) {
		int size = razas.get(especies.indexOf(pEspecie)).size();
		return new DefaultComboBoxModel<String>(razas.get(especies.indexOf(pEspecie)).toArray(new String[size]));
	}
	
	public static DefaultComboBoxModel<String> getModeloTamanios() {
		  return new DefaultComboBoxModel<String>(tamanios.toArray(new String[3]));
	}
	
	public static DefaultComboBoxModel<String> getModeloColores() {
		int size = colores.size();
		return new DefaultComboBoxModel<String>(colores.toArray(new String[size]));
	}
	
	public static ComboBoxModel<String> getModeloSexos() {
		return new DefaultComboBoxModel<String>(new String[]{"Macho", "Hembra"});
	}
	
	public static void addTamanio(String pTamanio){
		tamanios.add(pTamanio);
	}
	
	public static void addEspecie(String pEspecie){
		especies.add(pEspecie);
		razas.add(new LinkedList<String>());
	}
	
	public static void addRaza(String pEspecie, String pRaza){
		razas.get(especies.indexOf(pEspecie)).add(pRaza);	
	}
	
	public static void addColor(String pColor){
		colores.add(pColor);
	}
	
	public static LinkedList<String> getEspecies() {
		return especies;
	}

	public static LinkedList<LinkedList<String>> getRazas() {
		return razas;
	}

	public static Integer getTotalIDsRegistradas() {
		return totalIDsRegistradas;
	}
	
	public static void setTotalIDsRegistradas(Integer pTotal) {
		totalIDsRegistradas = pTotal;
	}
}

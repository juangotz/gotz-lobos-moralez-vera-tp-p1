package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class BalaEnemiga {
	private double x, y, escala, alto, ancho, velocidad;
	private boolean dir; // false = Izq
	private Image spriteIzq;
	private Image spriteDer;

	public BalaEnemiga(double x, double y, boolean direccion) {
		this.x = x;
		this.y = y;
		spriteIzq = Herramientas.cargarImagen("bomba2Izq.png");
		spriteDer = Herramientas.cargarImagen("bomba2.png");
		dir = direccion;
		escala = 0.03;
		alto = spriteIzq.getHeight(null) * escala;
		ancho = spriteIzq.getWidth(null) * escala;
		this.velocidad = 3;
	}

	public void mostrar(Entorno e) {
		if (dir) {
			e.dibujarImagen(spriteDer, x, y, 0, escala);
		} else {
			e.dibujarImagen(spriteIzq, x, y, 0, escala);
		}
	}

	public void moverse() {
		if (this.dir) {
			this.x += velocidad;
		} else {
			this.x -= velocidad;
		}
	}
	public boolean blebal_detectarColision(BalaEnemiga ble, Bala bl) {
		return (ble.getIzquierdo() < bl.getDerecho() && ble.getDerecho() > bl.getIzquierdo() &&
				ble.getTecho() < bl.getPiso() && ble.getPiso() > bl.getTecho());
	}	
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getTecho() {
		return y - alto / 2;
	}

	public double getPiso() {
		return y + alto / 2;
	}

	public double getDerecho() {
		return x + ancho / 2;
	}

	public double getIzquierdo() {
		return x - ancho / 2;
	}

}
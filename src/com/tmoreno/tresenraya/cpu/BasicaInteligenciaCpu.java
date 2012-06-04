package com.tmoreno.tresenraya.cpu;

import android.os.Parcel;

/**
 * Inteligencia de CPU b�sica o f�cil, s�lo busca casillas vac�as de forma aleatoria
 */
public class BasicaInteligenciaCpu extends InteligenciaCpu{
	
	/**
	 * @see InteligenciaCpu#getIdCasilla()
	 */
	@Override
	public int getIdCasilla() {
		return getCasillaAleatoria();
	}
	
	public static final Creator<BasicaInteligenciaCpu> CREATOR = new Creator<BasicaInteligenciaCpu>() {

		public BasicaInteligenciaCpu createFromParcel(Parcel source) {
			return new BasicaInteligenciaCpu();
		}
	
		public BasicaInteligenciaCpu[] newArray(int size) {
			return new BasicaInteligenciaCpu[size];
		}
	};
}

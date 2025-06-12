package lecon11;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Une liste (pour faire simple) d'entiers.
 */
public class IntLinkList {

	/*
	 * « Invariant » structurel :
	 * Si la liste est vide, start est null.
	 * 
	 * Sinon, start est non-null.
	 * start pointe vers la première cellule
	 * 
	 * 
	 * Schéma : (-- repésente une liaison)
	 * 
	 * (0)--(1)--(2)--(3)-- ... --(size()-1)
	 *  ^                             
	 *  start                       
	 */
	private Node start;
	private int size;

	/** 
	 * Construit une liste vide;
	 */
	public IntLinkList(){
		start = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public String toString() {

		if(isEmpty())
			return "()";

		StringJoiner sj = new StringJoiner(", ", "(", ")");

		Node curr = start;
		while (curr != null) {
			sj.add(Integer.toString(curr.value));
			curr = curr.next;
		}

		return sj.toString();
	}

	/**
	 * Ajout en fin de liste
	 * @param i
	 */
	public void add(int i) {
		// add(i, size);
		Node newNode = new Node(i, null);
		if (isEmpty()) {
			start = newNode;
		} else{
			Node curr = start;
			while(curr.next != null){
				curr = curr.next;
			}
			curr.next = newNode;
		}
		size++;
	}

	/**
	 * Parcours la liste et se positionne à la bonne cellule
	 * 
	 * Gère le bon positionnement
	 * @param pos
	 * @return le noeud à la pos position.
	 */
	private Node positionner(int pos) {
		Objects.checkIndex(pos, size);
		Node curr = start;

		for (int i = 0; i < pos; i++) {
			curr = curr.next;
		}

		return curr;
	}

	/**
	 * Ajout de i à la position pos.
	 * @param i
	 * @param pos
	 */
	public void add(int i, int pos) {
		// Ne pas oublier de mettre à jour tous les attributs !
		 if(size == 0) {
			 // TODO @Home : ajout en début de liste
			 
			 
		 } else {
			 Node newNode = new Node(i, null);
			 Node prec = positionner(pos-1);
			 newNode.next = prec.next;
			 prec.next = newNode;
		 }
		 size++;

	}

	/**
	 * Obtenir l'entier à la position pos.
	 * @param pos
	 * @return
	 */
	public int get(int pos) {
		Node e = positionner(pos);
		return e.value;
	}

	/**
	 * Retirer l'entier à la position pos.
	 * @param pos une position
	 */
	public void remove(int pos) {

		if(pos == 0) {
			Node toRemove = start;
			start = start.next;
			toRemove.next = null;
		} else {
			Node prec = positionner(pos - 1);
			Node toRemove = prec.next;
			prec.next = toRemove.next;
			toRemove.next = null;
		}
		size--;
	}

	/**
	 * Classe incluse dans la liste (oui, on peut...)
	 */
	private class Node {
		int value;
		Node next;

		Node(int value, Node next){
			this.value = value;
			this.next = next;
		}
	}
}

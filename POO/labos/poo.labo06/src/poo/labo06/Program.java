package poo.labo06;

import static poo.labo06.Tag.*;

import java.util.*;

import poo.labo06.requests.UserRequest;

/**
 * Ce programme liste les chaînes d'un bouquet selon plusieurs critères.
 * 
 * @author Nicolas Hendrikx
 * */
public class Program {

	/**
	 * Point d'entrée du programme.
	 * */
	public static void main(String[] args) {
		var channelsPackage = newChannelPackage();
		var input = new Scanner(System.in);
		var quitRequested = false;
		
		displayTitle();
		
		while(!quitRequested) {
			quitRequested = nextRequest(channelsPackage, input);
		}
	}

	private static void displayTitle() {
		System.out.println("POO - Labo 06 : Channels");		
		System.out.println("========================");
	}

	private static ChannelPackage newChannelPackage() {
		var channelsPackage = new ChannelPackage();
		// construire un bouquet de chaines
		channelsPackage.add(new Channel("La Une", 	List.of(Tag.GENERAL, Tag.PUBLIC, Tag.FRENCH)));
		channelsPackage.add(new Channel("La Deux", 	List.of(Tag.GENERAL, Tag.PUBLIC, Tag.FRENCH)));
		channelsPackage.add(new Channel("La Trois", List.of(Tag.KIDS, 	 Tag.PUBLIC, Tag.FRENCH)));
		channelsPackage.add(new Channel("Rtl-Tvi", 	List.of(Tag.GENERAL, Tag.PRIVATE, Tag.FRENCH)));
		channelsPackage.add(new Channel("Club-Rtl", List.of(Tag.CINEMA,  Tag.PRIVATE, Tag.FRENCH)));
		channelsPackage.add(new Channel("Plug-Rtl", List.of(Tag.CINEMA,  Tag.PUBLIC, Tag.FRENCH)));
		channelsPackage.add(new Channel("VRT", 		List.of(Tag.GENERAL, Tag.PUBLIC, Tag.DUTCH)));
		channelsPackage.add(new Channel("Canvas", 	List.of(Tag.CINEMA,  Tag.PUBLIC, Tag.DUTCH)));
		channelsPackage.add(new Channel("Sporza", 	List.of(Tag.SPORT,   Tag.PUBLIC, Tag.DUTCH)));
		channelsPackage.add(new Channel("VTM", 		List.of(Tag.GENERAL, Tag.PRIVATE, Tag.DUTCH)));
		//FIXME tableau vide wtf ?
			System.out.println(channelsPackage.toString());
		return channelsPackage;
	}

	private static boolean nextRequest(ChannelPackage channelsPackage, Scanner input) {
		var request = UserRequest.ofLine(readRequest(input));
		
		switch(request.getKind()){
		case LIST:
			return displayByInsertOrder(channelsPackage);
		case SHOW_TAGS:
			return displayTags();
		case FILTER_BY_TAG: 
			return displayByTags(channelsPackage, request.getArgAt(0));
		case EXIT:
			return displayQuit();
		default:
			return displayUnknownCommand();
		}
	}

	private static String readRequest(Scanner input) {
		System.out.print("Encodez une commande : ");
		return input.nextLine();
	}
	
	private static boolean displayByInsertOrder(ChannelPackage channelsPackage) {
		System.out.println("Chaines par ordre");
		System.out.println("-----------------");
		//TODO: afficher les chaines par ordre d'insertion
		for (Channel channel : channelsPackage) {
			System.out.println(channel);
		}
		
		return false;
	}

	private static boolean displayTags() {
		System.out.println("Liste des tags");
		System.out.println("--------------");
		// afficher les tags déclarés dans l'enum
		for (Tag tagName : Tag.values()) {
			System.out.println(tagName);
		}
		return false;
	}

	private static boolean displayByTags(ChannelPackage channelsPackage, String tag) {
		Tag seachTag = Tag.valueOf(tag.toUpperCase());
		System.out.println("Chaines "+seachTag);
		System.out.println("---------------------");
		
		// afficher les chaines par tags
		Iterator<Channel> it = channelsPackage.iteratorForTag(seachTag);
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		return false;
	}
	
	
	private static boolean displayUnknownCommand() {
		System.out.println("commande non-reconnue");
		return false;
	}

	private static boolean displayQuit() {
		System.out.println("Au revoir");
		return true;
	}

}

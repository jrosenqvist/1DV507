package jr222wb_assign3.norseGods;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class NorseGodMain extends Application {
	private static ArrayList<NorseGod> gods = new ArrayList<NorseGod>();
	
	public void start(Stage primaryStage) {
		HBox box = new HBox();
		
		//Create ListView with god names
		ListView<String> godList = new ListView<String>(); //New ListView
		godList.setPrefWidth(200);	//Set width
		for (NorseGod g : gods) { godList.getItems().add(g.getName()); } //Fill with name of gods from list
	}
	
	public static void main(String[] args) {
		//Create gods and add to list
		gods.add(new NorseGod("Thor", "Aesir", "In Norse mythology, Thor (/θɔːr/; from Old Norse Þórr) is a hammer-wielding god associated with thunder,"
				+ " lightning, storms, oak trees, strength, the protection of mankind, and also hallowing and fertility. The cognate deity in wider"
				+ " Germanic mythology and paganism was known in Old English as Þunor and in Old High German as Donar (runic þonar ᚦᛟᚾᚨᚱ), stemming"
				+ " from a Common Germanic *Þunraz (meaning \"thunder\").\n\nThor is a prominently mentioned god throughout the recorded history"
				+ " of the Germanic peoples, from the Roman occupation of regions of Germania, to the tribal expansions of the Migration Period, to"
				+ " his high popularity during the Viking Age, when, in the face of the process of the Christianization of Scandinavia, emblems of his"
				+ " hammer, Mjölnir, were worn and Norse pagan personal names containing the name of the god bear witness to his popularity."));
		
		gods.add(new NorseGod("Sif", "Aesir", "In Norse mythology, Sif is a goddess associated with earth. Sif is attested in the Poetic Edda,"
				+ " compiled in the 13th century from earlier traditional sources, and the Prose Edda, written in the 13th century by Snorri Sturluson,"
				+ " and in the poetry of skalds. In both the Poetic Edda and the Prose Edda, Sif is the wife of the thunder god Thor and is known for"
				+ " her golden hair.\n\nIn the Prose Edda, Sif is named as the mother of the goddess Þrúðr by Thor and of Ullr with a father whose name"
				+ " is not recorded. The Prose Edda also recounts that Sif once had her hair shorn by Loki, and that Thor forced Loki to have a golden"
				+ " headpiece made for Sif, resulting in not only Sif's golden tresses but also five other objects for other gods.\n\nScholars have"
				+ " proposed that Sif's hair may represent fields of golden wheat, that she may be associated with fertility, family, wedlock and/or"
				+ " that she is connected to rowan, and that there may be an allusion to her role or possibly her name in the Old English poem Beowulf."));
		
		gods.add(new NorseGod("Odin", "Aesir", "In Old Norse texts, Odin is depicted as one-eyed and long-bearded, frequently wielding a spear named"
				+ " Gungnir, and wearing a cloak and a broad hat. He is often accompanied by his animal companions and familiars—the wolves Geri and"
				+ " Freki and the ravens Huginn and Muninn, who bring him information from all over Midgard—and rides the flying, eight-legged steed"
				+ " Sleipnir across the sky and into the underworld. Odin is attested as having many sons, most famously the gods Thor (with Jörð)"
				+ " and Baldr (with Frigg), and is known by hundreds of names. In these texts, he frequently seeks greater knowledge, at times in"
				+ " disguise (most famously by obtaining the Mead of Poetry), makes wagers with his wife Frigg over the outcome of exploits, and takes"
				+ " part in both the creation of the world by way of slaying the primordial being Ymir and the gift of life to the first two humans Ask"
				+ " and Embla. Odin has a particular association with Yule, and mankind's knowledge of both the runes and poetry is also attributed to"
				+ " him, giving Odin aspects of the culture hero.\n\nIn Old Norse texts, female beings associated with the battlefield—the valkyries—are"
				+ " associated with the god and Odin oversees Valhalla, where he receives half of those who die in battle, the einherjar. The other half"
				+ " are chosen by the goddess Freyja for her afterlife location, Fólkvangr. Odin consults the disembodied, herb-embalmed head of the"
				+ " wise being Mímir for advice, and during the foretold events of Ragnarök, Odin is told to lead the einherjar into battle before being"
				+ " consumed by the monstrous wolf Fenrir. In later folklore, Odin appears as a leader of the Wild Hunt, a ghostly procession of the"
				+ " dead through the winter sky. He is associated with charms and other forms of magic, particularly in Old English and Old Norse texts."));
		
		gods.add(new NorseGod("Frigg", "Aesir", "In Germanic mythology, Frigg (Old Norse), Frija (Old High German), Frea (Langobardic), and Frige"
				+ " (Old English) is a goddess. In nearly all sources, she is described as the wife of the god Odin. In Old High German and Old Norse"
				+ " sources, she is also connected with the goddess Fulla. The English weekday name Friday (etymologically Old English \"Frīge's day\")"
				+ " bears her name.\n\nFrigg is described as a goddess associated with foreknowledge and wisdom in Norse mythology, the northernmost"
				+ " branch of Germanic mythology and most extensively attested. Frigg is the wife of the major god Odin and dwells in the wetland halls"
				+ " of Fensalir, is famous for her foreknowledge, is associated with the goddesses Fulla, Lofn, Hlín, and Gná, and is ambiguously"
				+ " associated with the Earth, otherwise personified as an apparently separate entity Jörð (Old Norse \"Earth\"). The children of Frigg"
				+ " and Odin include the gleaming god Baldr. Due to significant thematic overlap, scholars have proposed a particular connection to the"
				+ " goddess Freyja."));
		
		gods.add(new NorseGod("Baldr", "Aesir", "Baldr (also Balder, Baldur) is a Æsir god of light, joy, purity, and the summer sun in Norse mythology,"
				+ " and a son of the god Odin and the goddess Frigg. He is the father of Forseti, and He has numerous brothers, such as Thor and Váli."
				+ "\n\nIn the 12th century, Danish accounts by Saxo Grammaticus and other Danish Latin chroniclers recorded a euhemerized account of"
				+ " his story. Compiled in Iceland in the 13th century, but based on much older Old Norse poetry, the Poetic Edda and the Prose Edda"
				+ " contain numerous references to the death of Baldr as both a great tragedy to the Æsir and a harbinger of Ragnarök. In addition to"
				+ " being loved by all gods and more physical beings, he was so handsome, generous, and good that he gave off light simply by the purity"
				+ " of his character.\n\nAccording to Gylfaginning, a book of Snorri Sturluson's Prose Edda, Baldr's wife is Nanna and their son is"
				+ " Forseti. In Gylfaginning, Snorri relates that Baldr had the greatest ship ever built, Hringhorni, and that there is no place more"
				+ " beautiful than his hall, Breidablik."));
		
		gods.add(new NorseGod("Loki", "Aesir", "Loki (Old Norse [ˈloki], Modern Icelandic [ˈlɔːkɪ], often Anglicized as /ˈloʊki/) is a god in Norse"
				+ " mythology. Loki is in some sources the son of Fárbauti and Laufey, and the brother of Helblindi and Býleistr. By the jötunn"
				+ " Angrboða, Loki is the father of Hel, the wolf Fenrir, and the world serpent Jörmungandr. By his wife Sigyn, Loki is the father of"
				+ " Narfi and/or Nari. By the stallion Svaðilfari, Loki is the mother—giving birth in the form of a mare—to the eight-legged horse"
				+ " Sleipnir. In addition, Loki is referred to as the father of Váli in Prose Edda, though this source also refers to Odin as the"
				+ " father of Váli twice, and Váli is found mentioned as a Son of Loki only once.\n\nLoki's relation with the gods varies by source;"
				+ " Loki sometimes assists the gods and sometimes behaves in a malicious manner towards them. Loki is a shape shifter and in separate"
				+ " incidents he appears in the form of a salmon, a mare, a fly, and possibly an elderly woman named Þökk (Old Norse 'thanks')."
				+ " Loki's positive relations with the gods end with his role in engineering the death of the god Baldr and Loki is eventually bound"
				+ " by Váli with the entrails of one of his sons. In both the Poetic Edda and the Prose Edda, the goddess Skaði is responsible for"
				+ " placing a serpent above him while he is bound. The serpent drips venom from above him that Sigyn collects into a bowl; however,"
				+ " she must empty the bowl when it is full, and the venom that drips in the meantime causes Loki to writhe in pain, thereby causing"
				+ " earthquakes. With the onset of Ragnarök, Loki is foretold to slip free from his bonds and to fight against the gods among the"
				+ " forces of the jötnar, at which time he will encounter the god Heimdallr and the two will slay each other."));
		
	}
}

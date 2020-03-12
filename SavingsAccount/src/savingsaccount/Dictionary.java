import java.util.*;

// This is a class that only holds and returns an array of strings of all 
// possible three letter words. I got the list from https://scrabble.merriam.com/3-letter-words
public class Dictionary {
    
    public Dictionary(){};
    String dictionary = "aahaalaasabaabsabyaceactaddadoadsadzaffaftagaageagoagsa"
            + "haahiahsaidailaimainairaisaitajialaalbaleallalpalsaltamaamiampamu"
            + "anaandaneaniantanyapeapoappaptarbarcarearfarkarmarsartashaskaspas"
            + "sateattaukavaaveavoawaaweawlawnaxeayeaysazobaabadbagbahbalbambanb"
            + "apbarbasbatbaybedbeebegbelbenbesbetbeybibbidbigbinbiobisbitbizboa"
            + "bobbodbogboobopbosbotbowboxboybrabrobrrbubbudbugbumbunburbusbutbu"
            + "ybyebyscabcadcafcamcancapcarcatcawcayceecelcepchicigciscobcodcogc"
            + "olconcoocopcorcoscotcowcoxcoycozcrucrycubcudcuecumcupcurcutcuzcwm"
            + "dabdaddagdahdakdaldamdandapdasdawdaydebdeedefdeldendepdevdewdexde"
            + "ydibdiddiedifdigdimdindipdisditdocdoedogdohdoldomdondordosdotdowd"
            + "rydubdudduedugduhduidumdunduodupdyeeareateauebbecoecuedhedseekeel"
            + "eeweffefsefteggegoekeeldelfelkellelmelsemeemoemsemuendengenseoner"
            + "aereergernerrersessestetaetheveeweeyefabfadfagfahfanfarfasfatfaxf"
            + "ayfedfeefehfemfenferfesfetfeufewfeyfezfibfidfiefigfilfinfirfitfix"
            + "fizfluflyfobfoefogfohfonfoofopforfoufoxfoyfrofryfubfudfugfunfurga"
            + "bgadgaegaggalgamgangapgargasgatgaygedgeegelgemgengetgeyghigibgidg"
            + "iegifgiggingipgisgitgnugoagobgodgoogorgosgotgoxgrrgulgumgungutguv"
            + "guygymgyphadhaehaghahhajhamhaohaphashathawhayhehhemhenhepherheshe"
            + "thewhexheyhichidhiehimhinhiphishithmmhobhodhoehoghomhonhoohophoth"
            + "owhoyhubhuehughuhhumhunhuphuthypiceichickicyidsiffifsiggilkillimp"
            + "inkinninsionireirkismitsivyjabjagjamjarjawjayjeejetjeujibjigjinjo"
            + "bjoejogjotjowjoyjugjunjusjutkabkaekafkaskatkaykeakefkegkenkepkexk"
            + "eykhikidkifkinkipkirkiskitkoakobkoikopkorkoskuekyelablacladlaglah"
            + "lamlaplarlaslatlavlawlaxlaylealedleelegleilekletleulevlexleylibli"
            + "dlielinliplislitlobloglooloplotlowloxludluglumlunluvluxlyemacmadm"
            + "aemagmammanmapmarmasmatmawmaxmaymedmegmehmelmemmenmetmewmhomibmic"
            + "midmigmilmimmirmismixmmmmoamobmocmodmogmoimolmommonmoomopmormosmo"
            + "tmowmudmugmummunmusmutmuxmycnabnaenagnahnamnannapnavnawnaynebneen"
            + "egnetnewnibnilnimnipnitnixnobnodnognohnomnoonornosnotnownthnubnug"
            + "nunnusnutoafoakoaroatobaobeobiocaochodaoddodeodsoesoffoftohmohooh"
            + "soikoilokaokeoldoleomaomsoneonoonsoofoohootopaopeopsoptoraorborco"
            + "reorgorsortoseoudouroutovaoweowlownowtoxooxypacpadpahpakpalpampan"
            + "papparpaspatpawpaxpaypeapecpedpeepegpehpenpepperpespetpewphiphoph"
            + "tpiapicpiepigpinpippispitpiupixplypodpohpoipolpompoopoppospotpowp"
            + "oxproprypsipstpubpudpugpulpunpuppurpusputpyapyepyxqatqisquaradrag"
            + "rahrairajramranraprasratrawraxrayrebrecredreerefregreiremrepresre"
            + "trevrexrezrhoriaribridrifrigrimrinriprobrocrodroeromroorotrowrubr"
            + "uerugrumrunrutryaryeryusabsacsadsaesagsalsansapsatsausawsaxsaysea"
            + "secseesegseiselsensersetsevsewsexshasheshhshoshysibsicsigsimsinsi"
            + "psirsissitsixskaskiskyslysobsocsodsohsolsomsonsopsossotsousowsoxs"
            + "oyspaspysristysubsuesuksumsunsupsuqsussyntabtadtaetagtajtamtantao"
            + "taptartastattautavtawtaxteatectedteetegteltentestettewthethothyti"
            + "ctietiltintiptistittixtiztodtoetogtomtontootoptortottowtoytrytskt"
            + "ubtugtuitumtuntuptuttuxtwatwotyeudoughukeuluummumpumsuniunsupoups"
            + "urburdurnurpuseutauteutsvacvanvarvasvatvauvavvawveevegvetvexviavi"
            + "dvievigvimvinvisvoevogvowvoxvugvumwabwadwaewagwanwapwarwaswatwaww"
            + "axwaywebwedweewenwetwhawhowhywigwinwiswitwizwoewokwonwoowoswotwow"
            + "wrywudwyewynxisyagyahyakyamyapyaryasyawyayyeayehyenyepyesyetyewyi"
            + "nyipyobyodyokyomyonyouyowyukyumyupzagzapzaszaxzedzeezekzenzepzigz"
            + "inzipzitzoazoozuzzzz";

    // method that returns a list of the dictionary string split every three
    // characters
    public String[] wordList()
    {
       return dictionary.split("(?<=\\G...)");
    }
    
    
}

import model._
import math._

object Test {
    val swissPop = 7160400                        //> swissPop  : Int = 7160400
    val fre = new CountryLanguage("CHE", "French", true, 19.2666)
                                                  //> fre  : model.CountryLanguage = (CHE, French, true, 19.2666)
    val ger = new CountryLanguage("CHE", "German", true, 63.6555)
                                                  //> ger  : model.CountryLanguage = (CHE, German, true, 63.6555)
    val ita = new CountryLanguage("CHE", "Italian", true, 7.7111)
                                                  //> ita  : model.CountryLanguage = (CHE, Italian, true, 7.7111)
    val rom = new CountryLanguage("CHE", "Romansh", true, 0.6111)
                                                  //> rom  : model.CountryLanguage = (CHE, Romansh, true, 0.6111)
    
    val swissLanguages = List(fre, ger, ita, rom) //> swissLanguages  : List[model.CountryLanguage] = List((CHE, French, true, 19.
                                                  //| 2666), (CHE, German, true, 63.6555), (CHE, Italian, true, 7.7111), (CHE, Rom
                                                  //| ansh, true, 0.6111))
    val langPer = swissLanguages.map(cl => (cl.language, cl.percentage))
                                                  //> langPer  : List[(String, Double)] = List((French,19.2666), (German,63.6555),
                                                  //|  (Italian,7.7111), (Romansh,0.6111))
	  val popLang = langPer.map(cl => (cl._1, (cl._2 / 100) * swissPop))
                                                  //> popLang  : List[(String, Double)] = List((French,1379565.6264), (German,4557
                                                  //| 988.422), (Italian,552145.6044), (Romansh,43757.2044))
	  
	  val popLangRound = popLang.map(cl => (cl._1, floor(cl._2 * 100) / 100))
                                                  //> popLangRound  : List[(String, Double)] = List((French,1379565.62), (German,4
                                                  //| 557988.42), (Italian,552145.6), (Romansh,43757.2))
    
}
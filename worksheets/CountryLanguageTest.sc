import model._

object Test {
    val swissPop = 7160400                        //> swissPop  : Int = 7160400
    val fre = new CountryLanguage("CHE", "French", true, 19.2)
                                                  //> fre  : model.CountryLanguage = CHE, French, true, 19.2
    val ger = new CountryLanguage("CHE", "German", true, 63.6)
                                                  //> ger  : model.CountryLanguage = CHE, German, true, 63.6
    val ita = new CountryLanguage("CHE", "Italian", true, 7.7)
                                                  //> ita  : model.CountryLanguage = CHE, Italian, true, 7.7
    val rom = new CountryLanguage("CHE", "Romansh", true, 0.6)
                                                  //> rom  : model.CountryLanguage = CHE, Romansh, true, 0.6
    
    val swissLanguages = List(fre, ger, ita, rom) //> swissLanguages  : List[model.CountryLanguage] = List(CHE, French, true, 19.2
                                                  //| , CHE, German, true, 63.6, CHE, Italian, true, 7.7, CHE, Romansh, true, 0.6)
                                                  //| 
    val langPer = swissLanguages.map(cl => (cl.language, cl.percentage))
                                                  //> langPer  : List[(String, Double)] = List((French,19.2), (German,63.6), (Ital
                                                  //| ian,7.7), (Romansh,0.6))
    val popLang = langPer.map( cl => (cl._1, (cl._2 / 100) * swissPop))
                                                  //> popLang  : List[(String, Double)] = List((French,1374796.8), (German,4554014
                                                  //| .4), (Italian,551350.8), (Romansh,42962.4))
    
}
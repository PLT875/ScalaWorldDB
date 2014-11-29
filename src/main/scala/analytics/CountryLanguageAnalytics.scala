package analytics
import model._

object CountryLanguageAnalytics {
	def languagePopulation(countryLanguages : List[CountryLanguage], countryPopulation : Int): List[(String, Double)] = {
	    val langPercentage = countryLanguages.map(cl => (cl.language, cl.percentage))
    	val langPopulation = langPercentage.map( cl => (cl._1, (cl._2 / 100) * countryPopulation))
	    langPopulation
	}
}
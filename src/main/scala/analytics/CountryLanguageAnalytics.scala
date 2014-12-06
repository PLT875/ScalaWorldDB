package analytics
import model._
import math._

object CountryLanguageAnalytics {
	
	def languagePopulation(countryPopulation : Int)(countryLanguages : List[CountryLanguage]): List[(String, Double)] = {
		val langPercentage = countryLanguages.map(cl => (cl.language, cl.percentage))
		val langPopulation = langPercentage.map(cl => (cl._1, (cl._2 / 100) * countryPopulation))
		val popLang = langPopulation.map(cl => (cl._1, floor(cl._2 * 100) / 100))
		popLang
	}
}
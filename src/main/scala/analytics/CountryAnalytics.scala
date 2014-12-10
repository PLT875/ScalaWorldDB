package analytics
import model._

object CountryAnalytics {
	
	def populationDensity(countries : List[Country]): List[(String, Double)] = {
		countries.map(country => (
			country.name, (country.population / country.surfaceArea) - (country.population / country.surfaceArea) % 0.01 )
		)      
	}
	
}

package analytics

import model._

object CountryAnalytics {
  
	def populationDensity(countries : List[Country]): List[(String, String)] = {
	    countries.map(country => (country.name, "%.3f".format(country.population / country.surfaceArea)))
	}
	 
}
import model._
import dao._
import analytics._

object Test {
    
    val bru = new Country("Brunei", "Southeast Asia", 5765.0, 328000)
                                                  //> bru  : model.Country = Brunei, Southeast Asia, 5765.0, 328000
    val chn = new Country("China", "Eastern Asia", 9572900.0, 1277558000)
                                                  //> chn  : model.Country = China, Eastern Asia, 9572900.0, 1277558000
	  val hkg = new Country("Hong Kong", "Eastern Asia", 1075.0, 6782000)
                                                  //> hkg  : model.Country = Hong Kong, Eastern Asia, 1075.0, 6782000
	  val ind = new Country("Indonesia", "Southeast Asia", 1904569.0, 212107000)
                                                  //> ind  : model.Country = Indonesia, Southeast Asia, 1904569.0, 212107000
		val mac = new Country("Macao", "Eastern Asia", 18.0, 473000)
                                                  //> mac  : model.Country = Macao, Eastern Asia, 18.0, 473000
		val countries = List(bru, chn, hkg, ind, mac)
                                                  //> countries  : List[model.Country] = List(Brunei, Southeast Asia, 5765.0, 3280
                                                  //| 00, China, Eastern Asia, 9572900.0, 1277558000, Hong Kong, Eastern Asia, 107
                                                  //| 5.0, 6782000, Indonesia, Southeast Asia, 1904569.0, 212107000, Macao, Easter
                                                  //| n Asia, 18.0, 473000)
		val popDensity = countries.map(country => (
	      country.name, (country.population / country.surfaceArea) - (country.population / country.surfaceArea) % 0.01 )
	  )                                       //> popDensity  : List[(String, Double)] = List((Brunei,56.89), (China,133.45), 
                                                  //| (Hong Kong,6308.83), (Indonesia,111.36), (Macao,26277.77))
	  
	  popDensity.sortWith( (x, y) => x._2 > y._2)
                                                  //> res0: List[(String, Double)] = List((Macao,26277.77), (Hong Kong,6308.83), (
                                                  //| China,133.45), (Indonesia,111.36), (Brunei,56.89))
		
		
		
		
}
import model._
import dao._
import analytics._

object Test {
    
    val bru = new Country("Brunei", "Southeast Asia", 5765.0, 328000)
                                                  //> bru  : model.Country = Brunei, Southeast Asia, 5765.0, 328000
    val bru2 = new Country("Arunei2", "Southeast Asia", 5765.0, 328000)
                                                  //> bru2  : model.Country = Arunei2, Southeast Asia, 5765.0, 328000
    val chn = new Country("China", "Eastern Asia", 9572900.0, 1277558000)
                                                  //> chn  : model.Country = China, Eastern Asia, 9572900.0, 1277558000
	  val hkg = new Country("Hong Kong", "Eastern Asia", 1075.0, 6782000)
                                                  //> hkg  : model.Country = Hong Kong, Eastern Asia, 1075.0, 6782000
	  val ind = new Country("Indonesia", "Southeast Asia", 1904569.0, 212107000)
                                                  //> ind  : model.Country = Indonesia, Southeast Asia, 1904569.0, 212107000
		val mac = new Country("Macao", "Eastern Asia", 18.0, 473000)
                                                  //> mac  : model.Country = Macao, Eastern Asia, 18.0, 473000
		val countries = List(bru, bru2, chn, hkg, ind, mac)
                                                  //> countries  : List[model.Country] = List(Brunei, Southeast Asia, 5765.0, 3280
                                                  //| 00, Arunei2, Southeast Asia, 5765.0, 328000, China, Eastern Asia, 9572900.0,
                                                  //|  1277558000, Hong Kong, Eastern Asia, 1075.0, 6782000, Indonesia, Southeast 
                                                  //| Asia, 1904569.0, 212107000, Macao, Eastern Asia, 18.0, 473000)
		val popDensity = countries.map(country => (country.name, "%.3f".format(country.population / country.surfaceArea)))
                                                  //> popDensity  : List[(String, String)] = List((Brunei,56.895), (Arunei2,56.895
                                                  //| ), (China,133.456), (Hong Kong,6308.837), (Indonesia,111.367), (Macao,26277.
                                                  //| 778))
		
		
		
}
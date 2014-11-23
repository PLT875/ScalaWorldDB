import model._
import dao._
import analytics._

object Test {
   sealed trait NldCities {
	   val ams = new City("Amsterdam", "NLD", "Noord-Holland", 731200)
		 val rot = new City("Rotterdam", "NLD", "Zuid-Holland", 593321)
		 val haa = new City("Haag", "NLD", "Zuid-Holland", 440900)
		 val ein = new City("Eindhoven", "NLD", "Noord-Brabant", 201843)
	   val til = new City("Tilburg", "NLD", "Noord-Brabant", 193238)
		 val bre = new City("Breda", "NLD", "Noord-Brabant", 160398)
	   val ape = new City("Apeldoorn", "NLD", "Gelderland", 153491)
	   val nij = new City("Nijmegen", "NLD", "Gelderland", 152463)
	}
	
	class Netherlands extends NldCities
	
	
	val nld = new Netherlands                 //> nld  : Test.Netherlands = Test$Netherlands@6c7d3bc4
	val cityList = List(nld.ams, nld.rot, nld.haa, nld.ein, nld.til, nld.bre, nld.ape, nld.nij)
                                                  //> cityList  : List[model.City] = List(Amsterdam | NLD | Noord-Holland | 731200
                                                  //| , Rotterdam | NLD | Zuid-Holland | 593321, Haag | NLD | Zuid-Holland | 44090
                                                  //| 0, Eindhoven | NLD | Noord-Brabant | 201843, Tilburg | NLD | Noord-Brabant |
                                                  //|  193238, Breda | NLD | Noord-Brabant | 160398, Apeldoorn | NLD | Gelderland 
                                                  //| | 153491, Nijmegen | NLD | Gelderland | 152463)
	CityAnalytics.populationByDistrict(cityList)
                                                  //> res0: Map[String,Int] = Map(Gelderland -> 305954, Noord-Holland -> 731200, N
                                                  //| oord-Brabant -> 555479, Zuid-Holland -> 1034221)
	// val res1 = cityList.map(city => (city.district, city.population))
	// val res2 = res1.groupBy { case(district, population) => district }
	// val res3 = res2.map(district => (district._1, district._2.foldLeft(0)( (sum, const) => sum + const._2) ))
	
}
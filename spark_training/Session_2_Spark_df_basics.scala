import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.functions.{col}
import org.apache.log4j.Logger
import org.apache.log4j.Level

object DemoMain {

  Logger.getLogger("org").setLevel(Level.OFF)
  Logger.getLogger("akka").setLevel(Level.OFF)

  def main(args: Array[String]): Unit = {
    // get spark session object
    val spark = SparkSession.builder()
      .appName("Demo Test")
      .config("spark.master", "local")
      .getOrCreate()

    // Read from file
    val carsDf = spark.read
      .format("json")
      .option("schema", "true")
      .load("/Users/ssahu7/try/FL/TramPham/Resources/cars.json")



    // -------FILTER
    val usaCarsDf = carsDf.filter(col("Origin") === "USA")

    val nonUsaCarsDf = carsDf.filter(col("Origin") =!= "USA")

    // chain filters
    val americanPowerfulCarsDF = carsDf
      .filter(col("Origin") === "USA")
      .filter(col("Horsepower") > 150)


    val americanPowerfulCarsDF = carsDf.filter(col("Origin") === "USA" && col("Horsepower") > 150)

    // ---- distinct values
    val allCountriesDF = carsDf
      .select("Origin","Cylinders")
      .distinct()


    allCountriesDF.show

    // ---UNION

    // Read from file
    val moreCarsDf = spark.read
      .format("json")
      .option("inferSchema", "true")
      .load("/Users/ssahu7/try/FL/TramPham/Resources/more_cars.json")

    val allCarsDF = carsDf.union(moreCarsDf) // works if the DFs have the same schema

    allCarsDF.show()


    // Solve using CarsDf :
    // i> Find no of cars in Japan
    // ii> How many unique car names are there?
    //iii> Find the value of (Acceleration+Cylinders)/(Displacement * Horsepower) for the car "chevrolet impala" from "USA" in the year "1973-01-01"
    //(Efficient way)
    // vi> FInd average horsepower of the carsDf. [There is a direct spark method , but try to solve it manually using scala operations]




    }
}
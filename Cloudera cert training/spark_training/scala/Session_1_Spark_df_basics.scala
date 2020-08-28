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

    println("Done")

    //Show dataframe
    carsDf.show()

    //Show only 5 rows
    carsDf.show(5)

    //Show only 5 rows Non Truncate
    carsDf.show(5, false)

    //schema
    carsDf.printSchema()

    //Limit
    val carDfSmall = carsDf.limit(5)
    println(carDfSmall.count)
    val abc = carDfSmall.take(2)
    println(carDfSmall.take(2))



    //- df : array of rows matching the SCHEMA  distributed accross nodes


    //Limit

    carsDf.limit(5)

    //TAKE n rows and print. [Take brings to driver]
    //Don't do unless you really need in a local variable.
    println(carsDf.take(1).apply(0))

    //Collect : [brings to driver] : converts Df to array of rows
    val carRows = carsDf.limit(5).collect()


    val acc = carsDf.take(1).apply(0).apply(0)
    println(acc);

    //------ MANUAL CREATE DF FROW Seq
    val someData = Seq(
      (8, "bat"),
      (64, "mouse"),
      (-27, "horse")
    )

    val someDF = spark.createDataFrame(someData)

    someDF.show()
    someDF.printSchema()

    //Count no of rows
    println(carsDf.count)


    //------ Basic Operations

    //select
    val carNamesDf = carsDf.select("name")
    carNamesDf.show()

    val carNamesAccDf = carsDf.select("Name", "Acceleration")
    carNamesAccDf.show

    //Using col , simple ops
    carNamesAccDf.select(col("Acceleration"), col("Acceleration") / 2).show

    //Alias
    carNamesAccDf.select(col("Acceleration"), (col("Acceleration") / 2).as("Half Acc")).show


    // adding a column
    val carsWithKg3DF = carsDf.withColumn("Acc_Cyn", col("Acceleration") + col("Cylinders"))
    carsWithKg3DF.show()

    // renaming a column
    val carsWithColumnRenamed = carsDf.withColumnRenamed("Weight_in_lbs", "Weight in pounds")

    // remove a column
    carsWithColumnRenamed.drop("Cylinders", "Displacement")

    }
}
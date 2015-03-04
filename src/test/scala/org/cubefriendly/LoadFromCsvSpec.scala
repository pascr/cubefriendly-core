package org.cubefriendly

import java.io.File

import org.cubefriendly.data.Cube
import org.mapdb.{DBMaker, DB}
import org.specs2.mutable.Specification

/**
 * Cubefriendly
 * Created by david on 03.03.15.
 */
class LoadFromCsvSpec extends Specification{
  "A Cube data" should {

    def db():DB = DBMaker.newFileDB(new File("fromcsv.cube")).make()

    "be loaded from CSV" in {
      val cubeName = "test_cube"
      val csvFile = new File("src/test/resources/test.csv")
      val actual: Cube = Cube.fromCsv(csvFile,db()).toCube(cubeName)
      actual.name must be equalTo cubeName
      success
    }
  }

}

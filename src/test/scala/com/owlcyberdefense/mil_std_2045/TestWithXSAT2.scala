package com.owlcyberdefense.mil_std_2045

import com.owlcyberdefense.xsat2.{Utils, XSAT2SchemaQualityChecker}
import org.apache.daffodil.util.Misc
import org.junit.{Ignore, Test}

class TestWithXSAT2 {

  @Ignore("Use to run XSAT2 report manually.")
  @Test
  def test_xsat2_schema(): Unit = {
    val uri = Utils.getRequiredResource("com/")
    XSAT2SchemaQualityChecker.doXSAT2(uri, System.out)
  }

  @Ignore("Use to run XSAT2 report manually.")
  @Test
  def test_src_xsat2_schema(): Unit = {
    XSAT2SchemaQualityChecker.doXSAT2("src/main/resources/com/owlcyberdefense/mil-std-2045/xsd/", System.out)
  }
}

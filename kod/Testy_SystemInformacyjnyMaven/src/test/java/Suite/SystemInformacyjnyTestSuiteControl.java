/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */
package Suite;

import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import systeminformacyjny.kontroler.AplikacjaTest;

@Suite
@SelectClasses(AplikacjaTest.class)
@IncludeTags("Control")
@ExcludeTags("Entity")
public class SystemInformacyjnyTestSuiteControl { }

package basic.junit;

import org.junit.*;

/**
 * @Auther d
 * @Date 2022/3/26 17:01
 * @Describe 测试框架使用
 **/
public class JunitTest {
    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("@BeforeClass");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("@Before");
    }

    @Test
    public void testMathPow() {
        System.out.println("@Test2");
        Assert.assertEquals(4.0, Math.pow(2.0, 2.0), 0.0);
    }

    @Test
    public void testMathMin() {
        System.out.println("@Test2");
        Assert.assertEquals(2.0, Math.min(2.0, 4.0), 0.0);
    }

    // 期望此方法抛出NullPointerException异常
    @Test(expected = NullPointerException.class)
    public void testException() {
        System.out.println("@Test(expected = NullPointerException.class)");
        Object obj = null;
        obj.toString();
    }

    // 忽略此测试方法
    @Ignore
    @Test
    public void testMathMax() {
        Assert.fail("没有实现");
    }
    // 使用“假设”来忽略测试方法
    @Test
    public void testAssume(){
        System.out.println("Test assume");
        // 当假设失败时，则会停止运行，但这并不会意味测试方法失败。
        Assume.assumeTrue(false);
        Assert.fail("没有实现");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("@After");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("@AfterClass");
    }
}

/**
 * JUnit拡張.
 * <pre>
 * ・JUnitテスト範囲実行を提供
 *
 * JUnitテスト範囲実行とは、
 * JUnitテスト範囲実行をテストケースメソッドにアノテーションを付与してテストクラスアノテーションで
 * 範囲の実行もしくは、任意に指定するテストケースメソッドだけを実行する。
 *
 * 例）
 * @RunWith(OrderedRunner.class)
 * @TestRange(start=2, end=4)
 * public class HelloTest {
 *    @Test @Order(1)
 *    public void test1() {
 *      //
 *    }
 *    @Test @Order(2)
 *    public void test2() {
 *      //
 *    }
 *    @Test @Order(3)
 *    public void test3() {
 *      //
 *    }
 *    @Test @Order(4)
 *    public void test4() {
 *      //
 *    }
 * }
 * @Order(2), @Order(3), @Order(4) のメソッドが実行される。
 *
 * @TestRange(start=2) の指定で、@Order(2) 以降のメソッドは実行される。
 *
 * @TestRange(x={1, 3}) の指定で、@Order(1)と@Order(3)のメソッドだけが実行される。
 *
 * ｘ配列の指定をした場合、start, end の指定は無効である。
 *
 * </pre>
 */
package org.yipuran.junit;
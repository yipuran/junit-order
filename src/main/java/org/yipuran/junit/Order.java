package org.yipuran.junit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Order. テスト順位アノテーション
 * <pre>
 * テストケースメソッドに、実行する順位を指定する。
 *
 * （例）
 * @Test
 * @Order(value=1)
 * public void testmethod1 {
 *    // test case 1
 * }
 * @Test
 * @Order(value=2)
 * public void testmethod2 {
 *    // test case 2
 * }
 *
 * //value名省略
 * @Test
 * @Order(3)
 * public void testmethod3 {
 *    // test case 3
 * }
 * </pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Order {
    int value();
}

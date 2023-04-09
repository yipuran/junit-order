package org.yipuran.junit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * テスト実行範囲指定アノテーション.
 * <pre>
 * @RunWith(OrderedRunner.class) と共にテストクラスに付与する。
 * @Order で指定したテストケースメソッドの順位に対して、テスト実行範囲または、選抜した順位のみを
 * 実行するように指定する。
 *
 * １番目から４番目までを実行する場合（@Order(1)のメソッドから@Order(4)のメソッド）
 * @TestRange(start=1, end=4)
 *
 * ２番目以降、最後の番号までを実行する場合（@Order(1)のメソッド以降）
 * @TestRange(start=2)
 *
 * ２番目、５番目、７番目のみを実行する場合は、x で配列を指定する。
 *    （@Order(2)のメソッド、@Order(5)のメソッド、@Order(7)のメソッド）
 * @TestRange(x={2, 5, 7})
 *
 * 配列を指定した場合、start, end の指定は無効で配列の順番で@Order のテストケースメソッドが
 * 実行される。
 *
 * </pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TestRange {
	int start() default 1;
	int end()   default 0;
	int[] x()  default {};
}

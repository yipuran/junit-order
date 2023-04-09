package org.yipuran.junit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
/**
 * テスト範囲実行の為の BlockJUnit4ClassRunner 継承.
 * <pre>
 * @RunWith で指定するBlockJUnit4ClassRunner 継承クラス
 *
 * @TestRange と共にテストクラス @RunWithアノテーションで指定する。
 *
 * @RunWith(OrderedRunner.class) をテストクラスに付与する
 * </pre>
 */
public class OrderedRunner extends BlockJUnit4ClassRunner {
	private TestRange range;
	public OrderedRunner(Class<?> cls) throws InitializationError  {
		super(cls);
		range = cls.getAnnotation(TestRange.class);
	}
	@Override
	protected List<FrameworkMethod> computeTestMethods() {
		List<FrameworkMethod> list = super.computeTestMethods();
		if (range==null) {
			return list.stream().sorted(new Comparator<FrameworkMethod>(){
				@Override
				public int compare(FrameworkMethod f1, FrameworkMethod f2){
					Order o1 = f1.getAnnotation(Order.class);
					Order o2 = f2.getAnnotation(Order.class);
					if (o1==null || o2==null){
						return -1;
					}
					return o1.value() - o2.value();
				}
			}).collect(Collectors.toList());
		}
		List<FrameworkMethod> res = list.stream().sorted(new Comparator<FrameworkMethod>(){
			@Override
			public int compare(FrameworkMethod f1, FrameworkMethod f2){
				Order o1 = f1.getAnnotation(Order.class);
				Order o2 = f2.getAnnotation(Order.class);
				if (o1==null || o2==null){
					return -1;
				}
				return o1.value() - o2.value();
			}
		}).collect(Collectors.toList());
		if (range.x().length > 0) {
			 return Arrays.stream(range.x()).mapToObj(i->res.get(i-1)).collect(Collectors.toList());
		}
		int end = range.end()==0 ? res.size() : range.end();
		return IntStream.rangeClosed(range.start(), end).boxed().map(i->res.get(i-1)).collect(Collectors.toList());
	}
}

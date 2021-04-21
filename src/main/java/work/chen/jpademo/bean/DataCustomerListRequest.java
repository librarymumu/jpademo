package work.chen.jpademo.bean;

import lombok.Data;

import java.awt.print.Pageable;
import java.io.Serializable;

/**
 * @ProjectName: jpa-demo
 * @Package: work.chen.jpademo.bean
 * @ClassName: DataCustomerListRequest
 * @Author: chencmumu
 * @Description: 客户列表参数
 * @Date: 2021/4/20 22:01
 * @Version: 1.0
 */

@Data
public class DataCustomerListRequest implements Serializable {

	// 客户姓名
	private String name;

	// 页码
	private int page;

	// 一页几条
	private int size;

	// 排序方式
	private String sort;

	// 排序字段
	private String sortFiled;

}

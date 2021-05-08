LibraryEntity ： 一的一方
BookEntity ： 多的一方
    配置双向绑定关系
        注意：
            1）lombok 不能直接使用@Data注解，双向绑定后，重写toString会导致内存溢出
            2）实体类中绑定关系，需要在绑定关系上标注@JsonIgnore注解
            3）
        方法说明(LibraryController)：
            1）save : 模拟保存主表数据和从表数据  请求地址 : localhost:8888/library/save
            2）update : 模拟更新主表数据（默认会更新所有字段） 请求地址 : localhost:8888/library/update
            3）findAll : 查询主表所有的数据 请求地址 : localhost:8888/library/findAll
            4）findLibrayAndBookData：: 查询主表及对应从表数据  请求地址 : localhost:8888/library/findLibrayAndBookData
 

 
CustomerEntity : 一的一方
OrderEntity : 多的一方
    多的一方配置单向绑定关系
    方法说明(CustomerController)：
    1）saveTest : 模拟保存 
    2）findAll : 模拟查询
    3）list : 条件分页查询
    4）leftJoin ： join 查询
 

 
 
SchoolEntity ： 一的一方
StudentEntity ： 多的一方
    多的一方配置单向绑定关系
    方法说明(SchoolController)：
        1）findAll ： 解决finAll方法查询 1 + N(N表示主表中的数据数量) 条查询sql 
    

    
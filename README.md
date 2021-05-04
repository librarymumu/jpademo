CustomerEntity 
    客户实体类 --> 一的一方
OrderEntity    
    订单实体列 --> 多的一方
绑定关系：
    声明在CustomerEntity（一的一方），OrderEntity（多的一方不做处理），去除数据库外键关联，只做关联字段assid
    
LibraryEntity
    图书馆实体类  --> 一的一方
BookEntity
    图书实体类  --> 多的一方
绑定关系：
    双向绑定，绑定在多的一方，一的一方参照多的一方   
    
 
 
解决finAll方法查询 1 + N(N表示主表中的数据数量) 条查询sql   
SchoolEntity
    学校实体类 --> 一的一方
StudentEntity
    学校实体类 --> 多的一方
绑定关系：
    声明在SchoolEntity（一的一方），StudentEntity（多的一方不做处理），去除数据库外键关联，只做关联字段scid
    
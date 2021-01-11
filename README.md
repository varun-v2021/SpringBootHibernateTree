# SpringBootHibernateTree

Run it as Junit test

Root parent will have parent id null
Mysql query to retrieve children from root parent having id 1

select id,
        category_name,
        parent_id
from    (select * from categories
         order by parent_id, id) categories,
        (select @pv := '1') initialisation
where   find_in_set(parent_id, @pv) > 0
and     @pv := concat(@pv, ',', id);

OR

select @pv:=id as id, category_name, parent_id from categories
join
(select @pv:=1)tmp
where parent_id=@pv

Mysql query to retrieve children from parent having id 2

select id,
        category_name,
        parent_id
from    (select * from categories
         order by parent_id, id) categories,
        (select @pv := '2') initialisation
where   find_in_set(parent_id, @pv) > 0
and     @pv := concat(@pv, ',', id);

References

https://stackoverflow.com/questions/53128781/how-to-query-a-hierarchical-category-tree-entity-with-undefined-depth
https://stackoverflow.com/questions/59259652/mysql-how-to-get-parent-and-all-child-for-given-id
https://stackoverflow.com/questions/20215744/how-to-create-a-mysql-hierarchical-recursive-query/20216006
https://stackoverflow.com/questions/41913460/mysql-recursive-get-all-child-from-parent

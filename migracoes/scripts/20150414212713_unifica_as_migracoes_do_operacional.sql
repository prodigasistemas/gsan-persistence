-- // unifica as migracoes do operacional
-- Migration SQL that makes the change goes here.

insert into public.changelog_batch_project select * from changelog_operacional_project

-- //@UNDO
-- SQL to undo the change goes here.


delete from public.changelog_batch_project where id in (select id from changelog_operacional_project)


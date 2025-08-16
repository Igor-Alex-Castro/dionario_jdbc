insert into dicionario (nome) 
select 'classicos' from dual 
where not exists (select 1 from dicionario where nome = 'classicos');
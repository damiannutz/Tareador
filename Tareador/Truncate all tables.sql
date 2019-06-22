use tareadorfinal;

set foreign_key_checks = 0;

-- no olvidarte de ninguna tabla

truncate table tipos_usuarios;

truncate table departamentos;

truncate table usuarios;

truncate table proyectos;

truncate table usuarios_x_proyectos;

truncate table roles;

truncate table roles_x_usuarios;

truncate table prioridades;

truncate table estados_tareas;

truncate table tipos_tareas;

truncate table tareas;

-- truncate table historial_tareas;

truncate table comentarios_tareas;

set foreign_key_checks = 1;


-- select * from tipos_usuarios;
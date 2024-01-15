<h4>Task - Hibernate</h4>
<p>Создать Web приложение учёта домов и жильцов>/p>
Описание:
<ol><li>2 сущности: House, Person</li>
<li>Система должна предоставлять REST API для выполнения следующих операций:
<p>CRUD для House: в GET запросах не выводить информацию о Person</p>
<p>CRUD для Person: в GET запросах не выводить информацию о House</p>
<p>Для GET операций использовать pagination (default size: 15)</p>
</li></ol>

House:
<ol><li>У House обязаны быть поля id, uuid, area, country, city, street, number, create_date</li>
<li>House может иметь множество жильцов (0-n)</li>
<li>У House может быть множество владельцев (0-n)</li>
<li>create_date устанавливается один раз при создании</li></ol>

Person:
<ol><li>У Person обязаны быть id, uuid, name, surname, sex, passport_series, passport_number, create_date, update_date</li>
<li>Person обязан жить только в одном доме и не может быть бездомным</li>
<li>Person не обязан владеть хоть одним домом и может владеть множеством домов</li>
<li>Сочетание passport_series и passport_number уникально</li>
<li>sex должен быть [Male, Female]</li>
<li>Все связи обеспечить через id</li>
<li>Не возвращать id пользователям сервисов, для этого предназначено поле uuid</li>
<li>create_date устанавливается один раз при создании</li>
<li>update_date устанавливается при создании и изменяется каждый раз, когда меняется информация о Person.</li>
<li>При этом, если запрос не изменяет информации, поле не должно обновиться</li></ol>


Примечание:
<ol><li>Ограничения и нормализацию сделать на своё усмотрение</li>
<li>Поля представлены для хранения в базе данных. В коде могут отличаться</li>li></ol>


Обязательно:
<ol><li>GET для всех Person проживающих в House</li>
<li>GET для всех House, владельцем которых является Person</li>
<li>Конфигурационный файл: application.yml</li>
<li>Скрипты для создания таблиц должны лежать в classpath:db/</li>
<li>create_date, update_date - возвращать в формате ISO-8601 (https://en.wikipedia.org/wiki/ISO_8601). Пример: 2018-08-29T06:12:15.156.</li>
<li>Добавить 5 домов и 10 жильцов. Один дом без жильцов и как минимум в 1 доме больше 1 владельца</li>
<li>Использовать репозиторий с JDBC Template для одного метода.</li></ol>

Дополнительно:
<ol><li>*Добавить миграцию</li>
<li>*Полнотекстовый поиск (любое текстовое поле) для House</li>
<li>*Полнотекстовый поиск (любое текстовое поле) для Person</li>
<li>**PATCH для Person и House</li></ol>

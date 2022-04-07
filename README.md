# sweet
## Данное приложение позволяет пользователю рассчитать стоимость своего приготовленного блюда
### В основе лежат такие технологии как БД SQLite, Spinner Adapter, Recycler Adapter,динамическое добавление View компонентов пользователем (также сбор данных из этих компонентов) и другие
**Приложение состоит из трёх layout**
+ На первом экране пользователю предлагают выяснить цену внесённого ингредиента за один грамм внести данный ингредиент и его цену за один грамм в собственную базу данных

![sweet1](https://user-images.githubusercontent.com/80197239/162144454-7a12a56b-76ea-4250-9962-d2ced2a848e7.png)
+	На втором экране пользователь должен посчитать стоимость своего блюда используя список ингредиентов, добавленных в БД(SQLite). Это можно сделать, нажав на кнопку (Плюс), которая создаёт два компонента (Spiner и Edit Text), в компоненте spinner пользователь должен выбрать ингредиент, который используется в рецепте и который содержит в себе стоимость за один грамм. А в компоненте Edit Text нужно ввести количество грамм, используемых в рецепте. И так проделать со всеми ингредиентами. В самом конце нажав на кнопку (цена порции) пользователю отображается цена его приготовленного ингредиента. 

![sweet2](https://user-images.githubusercontent.com/80197239/162144479-34599e86-ce7a-4c1e-a3e8-b8e8a844901e.png)

+ На третьем экране отображается список добавленных продуктов, которые можно удалить свайпом.

![sweet3](https://user-images.githubusercontent.com/80197239/162144497-72efce90-f0fd-4ed0-9f8e-c76f0f36c8fc.png)



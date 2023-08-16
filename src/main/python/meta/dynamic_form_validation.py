import json
from django import forms

fields_type_map = {
    'str': forms.CharField,
    'int': forms.IntegerField,
}

# form_description – наш json с описание формата
deserialized_form_description: dict = json.loads(form_description)
form_attrs = {}

# выбираем класс объекта поля в форме в зависимости от его типа
for field_name, field_description in deserialized_form_description.items():
    field_class = fields_type_map[field_description.pop('type')]
    form_attrs[field_name] = field_class(**field_description)

user_form_class = type('DynamicForm', (forms.Form, ), form_attrs)
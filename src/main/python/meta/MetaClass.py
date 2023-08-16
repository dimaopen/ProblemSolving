class User: pass
user = User()

print(User)
print(type(user))
print(type(User))

User = type('User', (), {})
user = User()

print(User)
print(type(user))
print(type(User))
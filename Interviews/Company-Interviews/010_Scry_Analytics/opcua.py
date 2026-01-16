import opcua
from opcua import Client

client = Client("opc.tcp://18.217.202.240:4840")

client.connect()

# print(client.get_server_node())

# root = client.get_root_node()
# print("Objects node is: ", root)
# print("Children of root are: ", root.get_children())

print(client.get_namespace_array())
objects = client.get_objects_node()
print(objects)
print(objects.get_children())

temp = objects.get_children()[2]
temp2 = objects.get_children()[1]

# print(temp.get_children())

client.disconnect()

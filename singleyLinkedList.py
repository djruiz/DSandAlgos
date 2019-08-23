class node:

    def __init__(self, value):
        self.value = value
        self.next = None

    def getValue(self):
        return self.value

class SingleyLinkedList:

    def __init__(self):
        self.head = None
        self.tail = None

    def addNode(self, node):
        if self.head == None:
            self.head = node
            self.tail = node
        else:
            self.tail.next = node
            self.tail = node

    def getHead(self):
        return self.head.getValue()

    def getTail(self):
        return self.tail.getValue()

    def ex(self):
        current = self.head

        strRet = ""
        while current != self.tail:
            strRet += str(current.getValue()) + "->"
            current = current.next

        strRet += str(self.tail.getValue())
        return strRet

    # A - B - C - D - Null
    # D - C - B - A - Null

    def reverse_iterative(self):

        prev = None
        cur = self.head
        self.tail = cur

        while cur:
            nxt = cur.next
            cur.next = prev
            
            
            prev = cur
            cur = nxt

        self.head = prev
            
            
            

node1 = node(1)
node2 = node(2)
node3 = node(3)
node4 = node(4)
#node1.next = node2

list1 = SingleyLinkedList()
list1.addNode(node1)
list1.addNode(node2)
list1.addNode(node3)
list1.addNode(node4)

print(node1.getValue())
print(node1.next.getValue())

print(list1.getHead())
print(list1.getTail())

print(list1.ex())
list1.reverse_iterative()
print("reversed")
print(list1.ex())

    

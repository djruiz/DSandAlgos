class Node(object):

    def __init__(self, value):
        self.right = None
        self.left = None
        self.value = value

class BST(object):

    def __init__(self):
        self.root = None

    def insert(self, data):
        if self.root == None:
            self.root = Node(data)
        else:
            self.insert_helper(data, self.root)


    def insert_helper(self, data, node):
        if data < node.value:
            if node.left == None:
                node.left = Node(data)
            else:
                self.insert_helper(data, node.left)
        if data > node.value:
            if node.right == None:
                node.right = Node(data)
            else:
                self.insert_helper(data, node.right)

    def inorder_traversal(self, start, traversal):
        if start:
            traversal = self.inorder_traversal(start.left, traversal)
            traversal += str(start.value) + "-"
            traversal = self.inorder_traversal(start.right, traversal)

        return traversal

    def find(self, data):
        if self.root:
            found = self.find_helper(data, self.root)
            if found:
                return True
            return False
        else:
            return None
    
    def find_helper(self, data, curr_node):
        if curr_node.value < data and curr_node.right:
            return self.find_helper(data, curr_node.right)
        elif curr_node.value > data and curr_node.left:
            return self.find_helper(data, curr_node.left)
        if data == curr_node.value:
            return True


tree = BST()
tree.insert(1)
tree.insert(2)
tree.insert(0)
print(tree.inorder_traversal(tree.root, ""))
print(tree.find(1))



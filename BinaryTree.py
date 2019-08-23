class Node(object):

    def __init__(self, value):
        self.value = value
        self.right = None
        self.left = None

class BinaryTree(object):

    def __init__(self, root):
        self.root = Node(root)

    def print_tree(self, traversal_type):
        if traversal_type == "preorder":
            return self.preorder(tree.root, "")
        elif traversal_type == "inorder":
            return self.inorder(tree.root, "")
        elif traversal_type == "postorder":
            return self.postorder(tree.root, "")
        else:
            print("traversal type " + str(traversal_type) + " not supported")

    def preorder(self, start, traversal):
        #root -> left -> right
        if start:
            traversal += str(start.value) + "-"
            traversal = self.preorder(start.left, traversal)
            traversal = self.preorder(start.right, traversal)
        return traversal

    def inorder(self, start, traversal):
        #left -> root -> right
        if start:
            traversal = self.inorder(start.left, traversal)
            traversal += str(start.value) + "-"
            traversal = self.inorder(start.right, traversal)
        return traversal

    def postorder(self, start, traversal):
        #left -> right -> root
        if start:
            traversal = self.inorder(start.left, traversal)
            traversal = self.inorder(start.right, traversal)
            traversal += str(start.value) + "-"
            
        return traversal
        
    



#       1
#      /  \
#     2    3
#    / \  / \
#   4   5 6  7

#preorder: 1-2-4-5-3-6-7


tree = BinaryTree(1)
tree.root.left = Node(2)
tree.root.right = Node(3)

tree.root.left.left = Node(4)
tree.root.left.right = Node(5)

tree.root.right.left = Node(6)
tree.root.right.right = Node(7)

print(tree.print_tree("preorder"))
print(tree.print_tree("inorder"))
print(tree.print_tree("postorder"))

#include "bits-stdc++.h"
using namespace std;

struct TreeNode {
    struct TreeNode *left, *right;
    int val;
    TreeNode(int val) {
        val = val;
        left = NULL;
        right = NULL;
    }
};

class MyBinaryTree {
    // There are 2 type of traversal techniques BFS/DFS
    // Types of DFS techniques: InOrder Traversal, PreOrder Traversal, PostOrder
    // Traversal Types of BFS: Level Order Traversal, Radial Traversal (Radially
    // upward downwards always)

   private:
    int findIndex(vector<int> &inorder, int root) {
        for (int i = 0; i < inorder.size(); i++) {
            if (inorder[i] == root) {
                return i;
            }
        }
        return -1;
    }

   public:
    void preorder(TreeNode *root)  // TC: O(N), SC: O(logN)
    {
        if (root == NULL) {
            return;
        }
        cout << root->val << " ";
        preorder(root->left);
        preorder(root->right);
    }

    void inorder(TreeNode *root)  // TC: O(N), SC: O(logN)
    {
        if (root == NULL) {
            return;
        }
        inorder(root->left);
        cout << root->val << " ";
        inorder(root->right);
    }

    void postorder(TreeNode *root)  // TC: O(N), SC: O(logN)
    {
        if (root == NULL) {
            return;
        }
        postorder(root->left);
        postorder(root->right);
        cout << root->val << " ";
    }

    void levelorder(TreeNode *root) {
        if (root == NULL) {
            return;
        }
        queue<TreeNode *> q;
        q.push(root);
        while (!q.empty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode *temp = q.front();
                q.pop();
                cout << temp->val << " ";
                if (temp->left) {
                    q.push(temp->left);
                }
                if (temp->right) {
                    q.push(temp->right);
                }
            }
        }
    }

    // Level Order to Binary Tree
    TreeNode *insertLevelOrder(vector<int> &arr, int i,
                               int n)  // TC: O(N), SC: O(n) + O(logN)
    {
        if (i < n) {
            TreeNode *root = new TreeNode(arr[i]);

            root->left = insertLevelOrder(arr, 2 * i + 1, n);
            root->right = insertLevelOrder(arr, 2 * i + 2, n);
            return root;
        }
        return NULL;
    }

    // All order traversal Preorder, Inorder, Postorder
    void allordertraversal(TreeNode *root) {
        stack<pair<TreeNode *, int>> st;
        vector<vector<int>> ans(3);
        if (root == NULL) {
            return;
        }
        st.push({root, 1});
        while (!st.empty()) {
            pair<TreeNode *, int> it = st.top();
            TreeNode *temp = it.first;
            int touches = it.second;
            st.pop();

            if (touches == 1) {
                ans[0].push_back(temp->val);
                touches++;
                st.push({temp, touches});
                if (temp->left) {
                    st.push({temp->left, 1});
                }
            } else if (touches == 2) {
                ans[1].push_back(temp->val);
                touches++;
                st.push({temp, touches});
                if (temp->right) {
                    st.push({temp->right, 1});
                }
            } else {
                ans[2].push_back(temp->val);
            }
        }
        for (auto x : ans) {
            for (auto i : x) {
                cout << i << " - ";
            }
            cout << endl;
        }
    }

    // 105. Construct Binary Tree from Preorder and Inorder Traversal
    TreeNode *binaryTreeFromPreorderAndInorder(vector<int> &preorder,
                                               vector<int> &inorder) {
        if (preorder.size() == 0 || inorder.size() == 0) {
            return NULL;
        }
        int rootIndexInInorder = findIndex(inorder, preorder[0]);
        TreeNode *root = new TreeNode(preorder[0]);
        vector<int> leftinorder(inorder.begin(),
                                inorder.begin() + rootIndexInInorder);
        vector<int> leftpreorder(preorder.begin() + 1,
                                 preorder.begin() + rootIndexInInorder + 1);
        root->left =
            binaryTreeFromPreorderAndInorder(leftpreorder, leftinorder);
        vector<int> rightinorder(inorder.begin() + rootIndexInInorder + 1,
                                 inorder.end());
        vector<int> rightpreorder(preorder.begin() + rootIndexInInorder + 1,
                                  preorder.end());
        root->right =
            binaryTreeFromPreorderAndInorder(rightpreorder, rightinorder);
        return root;
    }

    // 106. Construct Binary Tree from Inorder and Postorder Traversal
    TreeNode *binaryTreeFromInorderAndPostorder(vector<int> &inorder,
                                                vector<int> &postorder) {
        if (inorder.size() == 0 || postorder.size() == 0) {
            return NULL;
        }
        int x = postorder[postorder.size() - 1];
        TreeNode *root = new TreeNode(x);
        int i = findIndex(inorder, x);

        vector<int> leftinorder(inorder.begin(), inorder.begin() + i);
        vector<int> leftpostorder(postorder.begin(), postorder.begin() + i);
        root->left =
            binaryTreeFromInorderAndPostorder(leftinorder, leftpostorder);

        vector<int> rightinorder(inorder.begin() + i + 1, inorder.end());
        vector<int> rightpostorder(postorder.begin() + i, postorder.end() - 1);
        root->right =
            binaryTreeFromInorderAndPostorder(rightinorder, rightpostorder);

        return root;
    }

    vector<int> morrisInorderTraversal(TreeNode *root) {
        vector<int> inorder;
        if (root == NULL) {
            return inorder;
        }
        TreeNode *curr = root;
        while (curr) {
            if (curr->left != NULL) {
                TreeNode *prev = curr->left;
                while (prev->right && prev->right != curr) {
                    prev = prev->right;
                }
                if (prev->right == NULL) {
                    prev->right = curr;
                    curr = curr->left;
                }
                if (prev->right == curr) {
                    prev->right = NULL;
                    inorder.push_back(curr->val);
                    curr = curr->right;
                }
            } else {
                inorder.push_back(curr->val);
                curr = curr->right;
            }
        }
    }

    vector<int> morrisPreorderTraversal(TreeNode *root) {
        vector<int> preorder;
        if (root == NULL) {
            return preorder;
        }
        TreeNode *curr = root;
        while (curr) {
            if (curr->left != NULL) {
                TreeNode *prev = curr->left;
                while (prev->right && prev->right != curr) {
                    prev = prev->right;
                }
                if (prev->right == NULL) {
                    prev->right = curr;
                    preorder.push_back(curr->val);
                    curr = curr->left;
                }
                if (prev->right == curr) {
                    prev->right = NULL;
                    curr = curr->right;
                }
            } else {
                preorder.push_back(curr->val);
                curr = curr->right;
            }
        }
        return preorder;
    }
};

int main() {
    // TreeNode *root = new TreeNode(1);
    // root->left = new TreeNode(2);
    // root->right = new TreeNode(3);
    // root->left->right = new TreeNode(5);

    MyBinaryTree bt;
    // bt.preorder(root);
    // cout << endl;
    // bt.inorder(root);
    // cout << endl;
    // bt.postorder(root);
    // cout << endl;
    // bt.levelorder(root);
    // cout << endl;

    // vector<int> nums = {1, 2, 3, 4, 5};
    // TreeNode *root2 = bt.insertLevelOrder(nums, 0, nums.size());
    // bt.levelorder(root2);
    // cout << endl;

    // bt.allordertraversal(root);

    // vector<int> preorder = {3, 9, 20, 15, 7};
    // vector<int> inorder = {9, 3, 15, 20, 7};
    // TreeNode *root = bt.binaryTreeFromPreorderAndInorder(preorder, inorder);
    // bt.levelorder(root);
    // cout << endl;

    return 0;
}

// 979. Distribute Coins in Binary Tree
// https://leetcode.com/problems/distribute-coins-in-binary-tree/submissions/1261281704/?envType=daily-question&envId=2024-05-18
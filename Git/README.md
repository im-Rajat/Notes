# Git
 
- Git is a version control system.
- Git helps us to keep track of code changes.
- Git is used to collaborate on code.
- Git help us to Manage projects with **Repositories**

## Table of Contents

- [Git](#git)
- [Version Control System (VCS)](#version-control-system-vcs)
- [What is GitHub?](#what-is-github)
- [Configure Git](#configure-git)
- [Set up Git Repository](#set-up-git-repository)
- [Push Local Repository to GitHub](#push-local-repository-to-github)
- [Git Staging Environment](#git-staging-environment)
- [Git Commit](#git-commit)
    - [Git Commit without Stage](#git-commit-without-stage)
- [Git Branch](#git-branch)
    - [Git Branch Merge](#git-branch-merge)
- [Git Pull from GitHub](#git-pull-from-github)
- [Git Push to GitHub](#git-push-to-github)
- [Git Restore](#git-restore)
- [Deleting Files](#deleting-files)
- [Renaming File](#renaming-file)
- [Diff & Patch](#diff--patch)
- [Logging](#logging)
- [Use .gitignore](#use-gitignore)
- [Git Stash](#git-stash)
- [Update Forked Branch](#update-forked-branch)
- [Transfer Changes from Forked to Main Repository](#transfer-changes-from-forked-to-main-repository)
- [Changing History](#changing-history)
- [Miscellaneous](#miscellaneous)
- [GitHub](#github)
    - [Why GitHub?](#why-github)
    - [Working with GitHub](#working-with-github)
    - [Managing Projects with GitHub](#managing-projects-with-github)
    - [Syncing GitHub](#syncing-github)
- [References](#references)

### Version Control System (VCS)

- Git allows multiple developers to work on a project simultaneously without interfering with each other.
- It keeps track of changes made to the source code over time, making it easier to collaborate and manage different versions of a project.

### What is GitHub?

- Git is not the same as GitHub.
- GitHub is a web-based platform that provides hosting for software development and version control using Git
- GitHub makes tools that use Git.
- GitHub offers a range of features that enhance the development workflow and make it easier for teams to work together on software projects. 
- Key features provided by GitHub include:
    - Issues, Discussions, Pull requests, Notifications, Labels, Actions, Forks, Projects

### Configure Git

- We can download Git for free from the following website: https://www.git-scm.com/
- To check git version:
    - `git --version`
    - Output will look like 
- To configure Git, you m
- To configure Git, we must define some global variables: **user.name** and **user.email**. Both are required for you to make commits:
    - `git config --global user.name "<USER_NAME>"`
    - `git config --global user.email "<USER_EMAIL>"`
- To check the changes:
    - `git config --list`

### Set up Git repository

- Create a folder named NewProject using `mkdir` command. This folder will be the project directory, also called the working tree. The project directory is where all files related to your project are stored:
    - `mkdir NewProject`
- Change to the project directory by using the `cd` command.
    - `cd NewProject`
- Initialize our  new repository and set the name of the default branch to main:
    - `git init --initial-branch=main` or
    - `git init -b main`
- For earlier versions of Git, we can use these commands:
    - `git init`
    - `git checkout -b main`
- After running these initialize command, we will something similar like:
    - `Initialized empty Git repository in /home/<user>/Cats/.git/`
    - `Switched to a new branch 'main'`
- Get help from Git:
    - `git --help`
    - `git <any_command> -help` - see all the available options for the specific command, for example: `git commit -help`
    - `git help --all` -  see all possible commands

### Push Local Repository to GitHub

- First we need to create a Repository on GitHub.
- As we already set up a local Git repo, we are going to push that to GitHub Repository.
- We need to get https link of the GitHub Repository from GitHub.
- `git remote add origin URL` specifies that we are adding a remote repository, with the specified `URL`, as an `origin` to our local Git repo.
    - `git remote add origin https://github.com/im-Rajat/Git.git`
- Instead of above line use:
    - `git remote set-url origin https://<githubtoken>@github.com/<username>/<repositoryname>.git` : Need to have a Personal Access Token
- We need push our main branch to the origin url, and set it as the default remote branch:
    - `git push --set-upstream origin main`
    - `--set-upstream` is typically done when we have created a new branch locally and want to push it to the remote repository for the first time.
    - `-u` and `--set-upstream` are essentially the same. `-u` is a shorthand notation for `--set-upstream`.
- Since we are first time connecting to GitHub, we will get some kind of notification to authenticate.
- After push is successful, we can check GitHub and see that the repository has been updated.
  
### Git Staging Environment

- The staging environment allows you to selectively choose which changes in your working directory should be included in the next commit.
- Files in our Git repository folder can be in one of 2 states:
    - **Tracked:** files that Git knows about and are added to the repository.
    - **Untracked:** files that are in our working directory, but not added to the repository.
- To stage changes to prepare for a commit:
    - `git add`
- To check status of the working tree:
    - `git status`
    - `git status --short` - to see the changes in a more compact way
- To stage all ll files in the current directory to the Staging Environment:
    - `git add .` or
    - `git add --all`
    - The shorthand command for `git add --all` is `git add -A`
-  Unstage changes from the staging area, allowing us to modify or re-select changes before committing.
   -  `git reset`


### Git Commit

- We are ready move from `stage` to `commit` for our repo.
- When we `commit`, we should always include a message.
- The commit command performs a `commit`, and the `-m "message"` adds a message.
    - `git commit -m "<Your Message>"`
    - `git commit -m "Initial commit"`
- To see information about previous commits:
    - `git log`
- Make a commit without a commit message or blank commit message:
    - `git commit --allow-empty-message --no-edit`
- To create an empty Git commit with a specified commit message:
    - `git commit --allow-empty -m "Commit Message`
    -  It's useful when we want to make a commit that doesn't introduce any changes but serves a specific purpose, such as triggering a CI/CD pipeline or marking a milestone.

#### Git Commit without Stage:

- If you want to make a commit directly from your working directory (not using the staging environment), use this syntax:
- `git commit -a`
- `git commit -a -m "Our commit message here"` : This command automatically stages and commits all changes in tracked files in our working directory.
- This command only stages changes for files that are already being tracked by Git. It won't include changes in untracked files.
- The `-a` option stands for "all" and automatically stages any changes to tracked files before committing.

### Git Branch

- In Git, a `branch` is a new/separate version of the main repository.
- With a new branch called new-design, edit the code directly without impacting the main branch.
- Branches allow us to work on different parts of a project without impacting the main branch.
- Create a new branch:
    - `git branch new_branch` - Creates a new branch named "new_branch", but doesn't switch to it. We need to explicitly run `git checkout new_branch` to switch.
    - `git checkout -b new_branch` - Creates a new branch named "new_branch"and immediately switches to it.
    - `git switch -c new_branch` - Creates a new branch with the specified name and switches to it in one step.
- To list all branches in our repository:
    - `git branch`
    - The current branch is usually indicated with an asterisk (`*`).
- To retrieve the name of the currently checked out branch:
    - `git branch --show-current`
    - `git rev-parse --abbrev-ref HEAD`
- To switch to an existing branch:
    - `git checkout existing_branch` or
    - `git switch existing_branch` - with more recent versions of Git
- To checkout a specific hash:
    - `git checkout <commit_hash>`
- To delete a branch:
    - `git branch -d branch_to_delete`
    - `git branch -D branch_to_delete` - If the branch contains changes that haven't been merged, we may need to use `-D` to force the deletion:
    - `git branch --delete branch_to_delete` - The -d flag is a shorthand for --delete. It does the same thing.
    - Remember, deleting a branch locally does not delete it on the remote repository.
    - If we want to delete the branch from the remote repository as well, we would need to use: `git push origin --delete <branch_to_delete>`
- To rename a branch:
    - `git branch -m old_branch new_branch`
- To see remote branches:
    - `git branch -r`
- To see both local and remote branches:
    - `git branch -a`

#### Git Branch Merge

- Branch merging is a common operation in Git that involves combining changes from one branch into another.
- First Switch to the target branch:
    - Before we merge changes into a branch, we need to switch to the branch that will receive the changes (usually the main/master branch)
    - `git checkout main` or `git switch main`
- Merge the Source Branch:
    - Once we are on the target branch, use the `git merge` command to merge changes from the source branch
    - `git merge source_branch`
- Resolve Conflicts (if any):
    - Git will automatically merge most changes, but it may encounter conflicts if different branches modified the same file sections.
    - We manually need to edit the conflicted files to resolve the differences.
    - And Stage the resolved files with `git add.`
- Push Changes (if necessary):
    - After a successful merge, we may need to push the changes to the remote repository to make them available to others
    - `git push origin main`
    - `git push -f origin main`
- **Merge Conflict:** Need to choose which one of the branches we want to use or which one of the changes we want to use, and then accept everywhere in the project.
- Git Flow:
    - Feature/fix branch
    - Make changes
    - Merge to master
    - Delete old branch

### Git Pull from GitHub

- Use `pull` to update our local Git:
- To pull changes from a GitHub repository to your local repository, you can use the `git pull` command.
- The `git pull` command fetches changes from a remote repository (such as GitHub) and merges them into your current working branch.
- `git pull origin main` - If we are on the main branch
- `git pull` - If our local branch is tracking the remote branch, we can use a simpler form without specifying the remote or branch:
- `pull` is a combination of 2 different commands:
    - `fetch` & `merge`
- `fetch` gets all the change history of a tracked branch/repo.
    - `git fetch`
- After running `git fetch` we need to run `git merge` to merge those fetched changes
    - `git merge origin/main`
    - `merge` combines the current branch, with a specified branch.
- `git pull` combines the `git fetch` and `git merge` commands. It fetches changes from the remote repository and automatically merges them into the current branch.
- Use `git fetch` if:
    - We want to see what changes are on the remote branch before merging.
    - We want to fetch changes without automatically merging them into your working branch.
- Use `git pull` if:
    - We want to fetch changes and automatically merge them into your working branch.
    - We are confident that automatic merging will not lead to conflicts.

### Git Push to GitHub

- To push changes from your local Git repository to a repository on GitHub, you can use the `git push` command. 
- Stage your changes:
    - `git add .` - will stage all files
- Commit your changes:
    - `git commit -m "Your commit message here"`
- Push Changes to GitHub:
    - `git push origin main`
    - If this is first time we are pushing to the remote repository or if we haven't saved your GitHub credentials, we may be prompted to enter your GitHub username and password or a personal access token.
    - `git push -f origin main` -  to force push changes, the `-f` flag stands for "force" and it overrides the default behavior of Git, allowing us to overwrite the remote branch with your local changes. Should not use it.
    - `origin` - This is the default name of the remote repository. It represents the remote repository on GitHub.

### Git Restore

- To discard and restore all changes in the current working directory and revert all modified files to the state they were in at the last commit:
    - `git restore .`
    - `git checkout .` - For older versions
    - `git restore README.md` - To restore single file
- If we have added a file to  git using `git add README.md,` and we want to restore it from staging:
    - `git restore --staged README.md`
- Unstage a file, keeping the file changes:
    - `git reset <file_name>`
- Revert everything to the last commit:
    - `git reset --hard`
- `git reset <commit-id>` : unstage commit
- `git reset --hard <commit-id>` : dangerous command - this command will delete any commits, before the commit-id and also it will change all the files
- Git restore only works with changes in a file, not with new created file, it won't delete it. Git isn't doing anything with untracked files. We need to delete the new file manually. But we deleted a new file and then restore it, it will work and restore the deleted file.
- Git clean command lets us remove all un track files and directories from our branch super quickly:
    - `git clean` : only show what would be removed without actually removing anything
- Dry run, will show what will delete, good to run this first:
    - `git clean -n` (-n or --dry-run)
- `git clean -n` and `git clean` without any options both show what untracked files would be removed
- To perform the actual clean operation:
    - `git clean -f`
- Remove untracked directories in addition to untracked files.
    - `git clean -d`
- Remove untracked files and directories even if they are ignored by .gitignore rules:
    - `git clean -x` 


### Deleting Files

- We can delete file using explorer, after that we need to do staging (`git add .`) and `git commit`.
- If we run `git rm file_name.txt`, it will delete the file as well to the staging. Will make things ready to commit.
- To delete Directory/Multiples files:
    - `git rm -r folder_name` - The `rm -r` command will recursively remove our folder.

### Renaming File

- We can rename file using  explorer of vs editor, after if we check git status it will show as new file created and old file deleted.
    - Just like linux system do renaming, create a copy with new name, and delete old one.
- We can use git command, `git mv old_name.txt new_name.txt`, this step also do the staging (`git add .`) itself.


### Diff & Patch

- Diff of what is changed but not staged:
    - `git diff`
- Diff of what is staged but not yet committed:
    - `git diff --staged`
- To Create a patch:
    - `git diff > patch_name.patch`
- To use the patch and apply it :
    - `git apply patch_name.patch`
- Show the diff of what is in branchA that is not in branchB:
    - `git diff branchB...branchA`


### Logging

- Show the commit history for the currently active branch:
    - `git log`
- Check log in 1 line: 
    - `git log --oneline`
- Show the commits on branchA that are not on branchB:
    - `$ git log branchB..branchA`
- Command used to display the history of changes for a specific file, including its renaming or moving across commits:
    - `git log --follow file_name`
-  Provides detailed information about the specified commit:
    -  `git show <SHA>`

### Use .gitignore

- Why ignore files?
    - Sensitive info
    - Personal notes
    - System files
- We can add file name, folder (folder must end with slash / in end) in .gitignore file
- Global ignore File:
    - `git config --global core.excludesfile </path/to/global_ignore.txt>` (whenever we create a new project, it will pick up this file automatically)
-  To remove files from the index (also known as the cache or to unstage them) without deleting them from the working directory or the filesystem
    - `git rm --cached .`
    - `git rm --cached file_name` - for single file
    
### Git Stash

- Stash is a feature that allows us to temporarily store changes that are not ready to be committed to a branch.
- This is particularly useful when we need to switch branches or perform some other operation that requires a clean working directory, but we don't want to commit our changes yet
- To stash:
    - `git stash`
    - We can keep doing stash, it goes top of each other, like stack, latest on top.
- To save a stash with a message:
    - `git stash -m "my_stash_name"`
- To list stashes:
    - `git stash list`
- To apply a stash:
    - `git stash apply`
    - `git stash apply "stash@{n}"`
    - `git stash apply n`
    - `git restore .` (restore changes to original)
- To drop top hash, stash@{0}
    - `git stash drop` 
- To drop specific stash:
    - first see `git stash list`
    - `git stash drop stash@{n}`
- We can clear stashes from the stack using:
    - `git stash clear` - This removes all stashed changes.
- To apply and remove the most recent stash from the stack:
    - `git stash pop`
- Do this when we have conflict while doing git pull:
    - `git stash`
    - `git pull`
    - `git stash apply`
    - Change in source call as per requirement (<<<<<<<< search this)

### Update Forked Branch

- List remote repositories:
    - `git remove -v`
- If a new branch has been added to the original repository, it will not automatically appear in our forked repository.
- We will need to fetch the changes from the original repository and merge them into our forked repository.
- To do this, we can follow these steps:
    - Open your forked repository in a terminal or command prompt.
    - Add the original repository as a remote by running the command:
        - `git remote add upstream <original_repository_url>`
    - Fetch the changes from the original repository by running the command:
        - `git fetch upstream.`
    - Merge the changes into our forked repository by running the command:
        - `git merge upstream/<branch_name>` : Replace <branch_name> with the name of the branch that was added to the original repository. 
- After following these steps, the new branch should now be available in our forked repository.

### Transfer changes from Forked to Main Repository

```
# Clone the main repository
git clone https://github.com/im-Rajat/Git
cd Git

# Add the forked repository as a remote
git remote add forked https://github.com/im-Rajat-Forked/Git

# Fetch the branch from the forked repository
git fetch forked forked-update-git

# Create and switch to a new branch in the main repository
git checkout -b mainUpdateGit

# Merge the changes from the forked branch into the new branch
git merge forked/forked-update-git

# Resolve any merge conflicts if they arise

# Push the new branch to the main repository
git push origin mainUpdateGit
```

### Changing History

- Amending use to modify changes without new commit, add change into last commit.
- Command we use to add an item to a previous commit:
    - `git commit --amend` : redirect to editor to update the commit message if we want to
- `git commit -am "New commit message"` : update the commit message if we want to in terminal itself.
- `git commit -amend --no-edit` : no edit means, leave the message same as what we did in last commit
- Rebasing is another way of changing history, and designed to take the commits from one branch and apply them to another.
- `git rebase <branch>/<commit>`
- `git rebase --interactive <branch>/<commit>`
- `git rebase -i HEAD-2` : to back 2 step, redirect to editor
- `git rebase -i --root` : redirect to editor

### Miscellaneous

- Discard most recent commit:
    - `git reset --hard HEAD~1` : It will remove the recent commit but also reset the files, assuming that sitting on the previous commit.


# Github

### Why GitHub?

- Cloud Repository
- Collaborative Development
- Project Management

### Working with GitHub

- Set up remote
- Push
- Fetch/Pull

### Managing Projects with Github

- Contributors
- Issues
- Labels
- Milestones
- Projects

### Syncing Github

- Clone:
    - Git clone will take the copy of the GitHub repository, and place it on our local hard drive.
- Fetch:
    - If we already have a copy of the repository on our local hard drive, to sync the information from GitHub to local, we can issue a git fetch command.
    - Fetch download information and brings that information to our local repo
    - It actually do anything with the information, we need to run git merge after running git fetch command.
- Pull:
    - Git pull is a combination of doing a fetch, but also merging the data that is in our remote with our local version.

### References

- https://cheatsheets.zip/git
- https://learn.microsoft.com/en-us/training/modules/intro-to-git/
- https://www.w3schools.com/git/
- https://www.git-tower.com/learn/git/faq/push-to-github
- https://stackoverflow.com/questions/68775869/message-support-for-password-authentication-was-removed
- https://dev.to/github/how-to-undo-pushed-commits-with-git-2pe6
- https://learngitbranching.js.org/
- https://profy.dev/project/github-minesweeper/cheatsheet
- https://github.com/profydev/github-minesweeper-im-Rajat
- https://www.linkedin.com/learning/learning-git-and-github-14213624/https://github.com/LinkedInLearning/learning-git-github-2421501
- ChatGPT

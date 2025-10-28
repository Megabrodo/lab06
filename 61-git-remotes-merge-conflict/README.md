# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository
// git clone https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git lab06-es01 

2. Ci si assicuri di avere localmente entrambi i branch remoti
// cd lab06-es01
// git branch -a

3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
   e da qui si esegua il merge di `feature`
// git merge origin/feature

4. Si noti che viene generato un **merge conflict**!
5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)
// (modificato in visual code togliendo i <<<< e sistemando il resto)
// git add HelloWorld.java
// git commit -m 'merged conflict resolved'

6. Si crei un nuovo repository nel proprio github personale
7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote
// git remote add neworigin https://github.com/Megabrodo/lab06-01.git
// git remote -v

8. Si faccia push del branch `master` sul proprio repository
// git push -u neworigin master

9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale
// git log 


log di git bash:

zania@nbkSamueleZani MINGW64 ~ (master)
$ git clone https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git lab06-es01
Cloning into 'lab06-es01'...
remote: Enumerating objects: 12, done.
remote: Counting objects: 100% (4/4), done.
remote: Compressing objects: 100% (3/3), done.
remote: Total 12 (delta 1), reused 1 (delta 1), pack-reused 8 (from 1)
Receiving objects: 100% (12/12), done.
Resolving deltas: 100% (2/2), done.

zania@nbkSamueleZani MINGW64 ~ (master)
$ git branch -a

zania@nbkSamueleZani MINGW64 ~ (master)
$ cd lab06-es01

zania@nbkSamueleZani MINGW64 ~/lab06-es01 (master)
$ git branch -a
* master
  remotes/origin/HEAD -> origin/master
  remotes/origin/feature
  remotes/origin/master

zania@nbkSamueleZani MINGW64 ~/lab06-es01 (master)
$ git checkout -b
error: switch `b' requires a value

zania@nbkSamueleZani MINGW64 ~/lab06-es01 (master)
$ git checkout -b remotes/origin/master
Switched to a new branch 'remotes/origin/master'

zania@nbkSamueleZani MINGW64 ~/lab06-es01 (remotes/origin/master)
$ git branch -a
  master
* remotes/origin/master
  remotes/origin/HEAD -> origin/master
  remotes/origin/feature
  remotes/origin/master

zania@nbkSamueleZani MINGW64 ~/lab06-es01 (remotes/origin/master)
$ git checkout master
Switched to branch 'master'
Your branch is up to date with 'origin/master'.

zania@nbkSamueleZani MINGW64 ~/lab06-es01 (master)
$ git branch -a
* master
  remotes/origin/master
  remotes/origin/HEAD -> origin/master
  remotes/origin/feature
  remotes/origin/master

zania@nbkSamueleZani MINGW64 ~/lab06-es01 (master)
$ git merge origin/feature
Auto-merging HelloWorld.java
CONFLICT (content): Merge conflict in HelloWorld.java
Automatic merge failed; fix conflicts and then commit the result.

zania@nbkSamueleZani MINGW64 ~/lab06-es01 (master|MERGING)
$ git rm remotes/origin/master
fatal: pathspec 'remotes/origin/master' did not match any files

zania@nbkSamueleZani MINGW64 ~/lab06-es01 (master|MERGING)
$ git status
On branch master
Your branch is up to date with 'origin/master'.

You have unmerged paths.
  (fix conflicts and run "git commit")
  (use "git merge --abort" to abort the merge)

Unmerged paths:
  (use "git add <file>..." to mark resolution)
        both modified:   HelloWorld.java

no changes added to commit (use "git add" and/or "git commit -a")

zania@nbkSamueleZani MINGW64 ~/lab06-es01 (master|MERGING)
$ git add HelloWorld.java

zania@nbkSamueleZani MINGW64 ~/lab06-es01 (master|MERGING)
$ git commit -m 'merge conflict resolved'
[master ff1d3cc] merge conflict resolved

zania@nbkSamueleZani MINGW64 ~/lab06-es01 (master)
$ git status
On branch master
Your branch is ahead of 'origin/master' by 2 commits.
  (use "git push" to publish your local commits)

nothing to commit, working tree clean

zania@nbkSamueleZani MINGW64 ~/lab06-es01 (master)
$ git log
commit ff1d3cc0839ae7c2e92f0df9e9293b23953350e9 (HEAD -> master)
Merge: 8e0f29c bed943f
Author: Alessandro Zani <alessandro.zani3@studio.unibo.it>
Date:   Tue Oct 28 15:12:04 2025 +0100

    merge conflict resolved

commit bed943fbdd6ba94e64197448e4754a529d984e88 (origin/feature)
Author: Danilo Pianini <danilo.pianini@gmail.com>
Date:   Thu Oct 27 17:21:22 2016 +0200

    Print author information

commit 8e0f29c12e060f3bdc62540343eff3e473616d61 (origin/master, origin/HEAD, remotes/origin/master)
Author: Danilo Pianini <danilo.pianini@gmail.com>
Date:   Thu Oct 27 17:19:05 2016 +0200

    Change HelloWorld to print the number of available processors

commit d956df66aeb0829f23b7b3d0d9a1c002c390f87f
Author: Danilo Pianini <danilo.pianini@gmail.com>
Date:   Thu Oct 27 17:17:43 2016 +0200

    Create .gitignore

commit 700ee0b669f6cd75384abb9af51ca5c2adefe917
Author: Danilo Pianini <danilo.pianini@gmail.com>
Date:   Thu Oct 27 17:15:10 2016 +0200

    Create HelloWorld

zania@nbkSamueleZani MINGW64 ~/lab06-es01 (master)
$ git branch -a
* master
  remotes/origin/master
  remotes/origin/HEAD -> origin/master
  remotes/origin/feature
  remotes/origin/master

zania@nbkSamueleZani MINGW64 ~/lab06-es01 (master)
$ git remote add neworigin https://github.com/Megabrodo/lab06-01.git

zania@nbkSamueleZani MINGW64 ~/lab06-es01 (master)
$ git remote -v
neworigin       https://github.com/Megabrodo/lab06-01.git (fetch)
neworigin       https://github.com/Megabrodo/lab06-01.git (push)
origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git (fetch)
origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git (push)

zania@nbkSamueleZani MINGW64 ~/lab06-es01 (master)
$ git push -u neworigin master
Enumerating objects: 15, done.
Counting objects: 100% (15/15), done.
Delta compression using up to 4 threads
Compressing objects: 100% (11/11), done.
Writing objects: 100% (15/15), 1.56 KiB | 266.00 KiB/s, done.
Total 15 (delta 4), reused 10 (delta 2), pack-reused 0 (from 0)
remote: Resolving deltas: 100% (4/4), done.
To https://github.com/Megabrodo/lab06-01.git
 * [new branch]      master -> master
branch 'master' set up to track 'neworigin/master'.

zania@nbkSamueleZani MINGW64 ~/lab06-es01 (master)
$ git remote -v
neworigin       https://github.com/Megabrodo/lab06-01.git (fetch)
neworigin       https://github.com/Megabrodo/lab06-01.git (push)
origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git (fetch)
origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git (push)

zania@nbkSamueleZani MINGW64 ~/lab06-es01 (master)
$ git branch -a
* master
  remotes/origin/master
  remotes/neworigin/master
  remotes/origin/HEAD -> origin/master
  remotes/origin/feature
  remotes/origin/master

zania@nbkSamueleZani MINGW64 ~/lab06-es01 (master)
$ git push --set-upstream-to=neworigin
error: unknown option `set-upstream-to=neworigin'
usage: git push [<options>] [<repository> [<refspec>...]]

    -v, --[no-]verbose    be more verbose
    -q, --[no-]quiet      be more quiet
    --[no-]repo <repository>
                          repository
    --[no-]all            push all branches
    --[no-]branches       alias of --all
    --[no-]mirror         mirror all refs
    -d, --[no-]delete     delete refs
    --[no-]tags           push tags (can't be used with --all or --branches or --mirror)
    -n, --[no-]dry-run    dry run
    --[no-]porcelain      machine-readable output
    -f, --[no-]force      force updates
    --[no-]force-with-lease[=<refname>:<expect>]
                          require old value of ref to be at this value
    --[no-]force-if-includes
                          require remote updates to be integrated locally
    --[no-]recurse-submodules (check|on-demand|no)
                          control recursive pushing of submodules
    --[no-]thin           use thin pack
    --[no-]receive-pack <receive-pack>
                          receive pack program
    --[no-]exec <receive-pack>
                          receive pack program
    -u, --[no-]set-upstream
                          set upstream for git pull/status
    --[no-]progress       force progress reporting
    --[no-]prune          prune locally removed refs
    --no-verify           bypass pre-push hook
    --verify              opposite of --no-verify
    --[no-]follow-tags    push missing but relevant tags
    --[no-]signed[=(yes|no|if-asked)]
                          GPG sign the push
    --[no-]atomic         request atomic transaction on remote side
    -o, --[no-]push-option <server-specific>
                          option to transmit
    -4, --ipv4            use IPv4 addresses only
    -6, --ipv6            use IPv6 addresses only


zania@nbkSamueleZani MINGW64 ~/lab06-es01 (master)
$ git push --set-upstream-to=neworigin master
error: unknown option `set-upstream-to=neworigin'
usage: git push [<options>] [<repository> [<refspec>...]]

    -v, --[no-]verbose    be more verbose
    -q, --[no-]quiet      be more quiet
    --[no-]repo <repository>
                          repository
    --[no-]all            push all branches
    --[no-]branches       alias of --all
    --[no-]mirror         mirror all refs
    -d, --[no-]delete     delete refs
    --[no-]tags           push tags (can't be used with --all or --branches or --mirror)
    -n, --[no-]dry-run    dry run
    --[no-]porcelain      machine-readable output
    -f, --[no-]force      force updates
    --[no-]force-with-lease[=<refname>:<expect>]
                          require old value of ref to be at this value
    --[no-]force-if-includes
                          require remote updates to be integrated locally
    --[no-]recurse-submodules (check|on-demand|no)
                          control recursive pushing of submodules
    --[no-]thin           use thin pack
    --[no-]receive-pack <receive-pack>
                          receive pack program
    --[no-]exec <receive-pack>
                          receive pack program
    -u, --[no-]set-upstream
                          set upstream for git pull/status
    --[no-]progress       force progress reporting
    --[no-]prune          prune locally removed refs
    --no-verify           bypass pre-push hook
    --verify              opposite of --no-verify
    --[no-]follow-tags    push missing but relevant tags
    --[no-]signed[=(yes|no|if-asked)]
                          GPG sign the push
    --[no-]atomic         request atomic transaction on remote side
    -o, --[no-]push-option <server-specific>
                          option to transmit
    -4, --ipv4            use IPv4 addresses only
    -6, --ipv6            use IPv6 addresses only


zania@nbkSamueleZani MINGW64 ~/lab06-es01 (master)
$ git branch -vv
* master                ff1d3cc [neworigin/master] merge conflict resolved
  remotes/origin/master 8e0f29c Change HelloWorld to print the number of available processors

zania@nbkSamueleZani MINGW64 ~/lab06-es01 (master)
$ git status
On branch master
Your branch is up to date with 'neworigin/master'.

nothing to commit, working tree clean

zania@nbkSamueleZani MINGW64 ~/lab06-es01 (master)
$ git branch -a
* master
  remotes/origin/master
  remotes/neworigin/master
  remotes/origin/HEAD -> origin/master
  remotes/origin/feature
  remotes/origin/master

zania@nbkSamueleZani MINGW64 ~/lab06-es01 (master)
$ git log
commit ff1d3cc0839ae7c2e92f0df9e9293b23953350e9 (HEAD -> master, neworigin/master)
Merge: 8e0f29c bed943f
Author: Alessandro Zani <alessandro.zani3@studio.unibo.it>
Date:   Tue Oct 28 15:12:04 2025 +0100

    merge conflict resolved

commit bed943fbdd6ba94e64197448e4754a529d984e88 (origin/feature)
Author: Danilo Pianini <danilo.pianini@gmail.com>
Date:   Thu Oct 27 17:21:22 2016 +0200

    Print author information

commit 8e0f29c12e060f3bdc62540343eff3e473616d61 (origin/master, origin/HEAD, remotes/origin/master)
Author: Danilo Pianini <danilo.pianini@gmail.com>
Date:   Thu Oct 27 17:19:05 2016 +0200

    Change HelloWorld to print the number of available processors

commit d956df66aeb0829f23b7b3d0d9a1c002c390f87f
Author: Danilo Pianini <danilo.pianini@gmail.com>
Date:   Thu Oct 27 17:17:43 2016 +0200

    Create .gitignore

commit 700ee0b669f6cd75384abb9af51ca5c2adefe917
Author: Danilo Pianini <danilo.pianini@gmail.com>
Date:   Thu Oct 27 17:15:10 2016 +0200

    Create HelloWorld

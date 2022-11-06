module.exports = {
  branchPrefix: 'renovate/',
  dryRun: false,
  username: 'renovate-release',
  gitAuthor: 'Renovate Bot <bot@renovateapp.com>',
  platform: 'github',
  repositories: [
    'fujipon1126/version-catalog-sample'
  ],
  "labels": ["dependencies"],
  packageRules: [
    {
      matchUpdateTypes: [
        'pin',
        'digest',
        'patch',
        'minor',
        'major',
        'lockFileMaintenance'
      ]
    },
    {
      "matchSourceUrlPrefixes": ["https://github.com/firebase/"],
      "groupName": "All firebase packages"
    }
  ],
  extends: [
    "config:base",
    ":dependencyDashboard"
  ]
};
module.exports = {
  branchPrefix: 'develop',
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
    }
  ],
  extends: [
    "config:base",
    ":disableDependencyDashboard"
  ]
};
module.exports = {
  branchPrefix: 'renovate/',
  dryRun: null,
  username: 'renovate-release',
  gitAuthor: 'Renovate Bot <bot@renovateapp.com>',
  platform: 'github',
  repositories: [
    'fujipon1126/version-catalog-sample'
  ],
  labels: ["dependencies"],
  packageRules: [
    {
      // major,minor,patch以外のバージョンアップは無効
      matchUpdateTypes: [ 'pin', 'pinDigest', 'digest', 'lockFileMaintenance', 'rollback', 'bump'],
      enabled: false
    }
  ],
  extends: [
    "config:base",
    ":dependencyDashboard",
    ":prHourlyLimit4",
    ":prConcurrentLimit20"
  ]
};